import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] indegrees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegrees = new int[N + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N + 1; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegrees[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegrees[i] == 0){
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int num : graph.get(cur)) {
                indegrees[num]--;
                if(indegrees[num] == 0){
                    q.add(num);
                }
            }

            sb.append(cur + " ");
        }

        System.out.println(sb.toString());
    }
}