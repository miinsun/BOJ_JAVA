import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 학생들의 수
        M = Integer.parseInt(st.nextToken());   // 비교 횟수

        graph = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   // 부모
            int b = Integer.parseInt(st.nextToken());   // 자손

            graph[a][b] = 1;
        }

        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(bfs(i) == N - 1)
                answer++;
        }

        System.out.println(answer);
    }

    static int bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.add(n);
        visited[n] = true;

        int out = 0;
        while (!q.isEmpty()){
            int cur = q.poll();

            for(int i = 1; i <= N; i++){
                if(graph[cur][i] ==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    out++;
                }
            }
        }

        visited = new boolean[N + 1];
        int in = 0;

        q.offer(n);
        visited[n] = true;

        while (!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1; i <= N; i++){
                if(graph[i][cur] ==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    in++;
                }
            }
        }

        return out + in;
    }
}
