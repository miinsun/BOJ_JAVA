import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge{
    int s;
    int e;
    int w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

}

public class Main {
    static int[] parent;
    static ArrayList<Edge> list;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());    // 컴퓨터의 수
        M = Integer.parseInt(br.readLine());    // 연결할 수 있는 선의 수

        // 간선 정보 입력
        list = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Edge(s, e, w));
        }

        // 간선을 무게 오름차순으로 정렬
        Collections.sort(list, (e1, e2) -> e1.w - e2.w);

        // 그룹 정보 초기화
        parent = new int [N + 1];
        init();

        int answer = 0;
        for(Edge cur : list){
            // 간선이 같은 집합에 속해있지 않으면
            if(find(cur.s) != find(cur.e)){
                // 간선 선택
                answer += cur.w;
                // 같은 집합에 넣기
                union(cur.s, cur.e);
            }
        }

        System.out.println(answer);
    }

    static void init(){
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }
    }

    static int find(int a){
        if(a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        parent[aRoot] = bRoot;
    }
}
