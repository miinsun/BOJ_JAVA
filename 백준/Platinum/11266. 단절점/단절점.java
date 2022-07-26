import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 1; // 방문 순서
    static int[] order;
    static boolean[] isCut; // 단절점
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.valueOf(st.nextToken()); // 정점의 개수
        int E = Integer.valueOf(st.nextToken()); // 간선의 개수

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 인접 리스트 구현
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        order = new int[V + 1];
        isCut = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (order[i] == 0) {
                dfs(i, true);
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= V; i++) {
            if (isCut[i]) {
                cnt++;
            }
        }

        sb.append(cnt + "\n"); // 단절점의 개수

        for (int i = 1; i <= V; i++) {
            if (isCut[i]) {
                sb.append(i + " "); // 단절점의 번호 목록
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int cur, boolean isRoot) {
        order[cur] = cnt++; // 방문 순서 저장
        int ret = order[cur];
        int child = 0;

        for(int next : graph.get(cur)){
            if(order[next] == 0){
                child++;
                int low = dfs(next, false);
                if(!isRoot && low >= order[cur]){
                    isCut[cur] = true;
                }
                ret = Math.min(ret, low);
            }
            else{
                ret = Math.min(ret, order[next]);
            }
        }

        if(isRoot && child > 1){
            isCut[cur] = true;
        }

        return ret;
    }
}