import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/* BOJ - 1103 게임 */
public class Main {
    static int max = 0;
    static int N, M;
    static int[][] board;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N; i++){
            String tmp = br.readLine();
            for(int j = 0; j < M; j++){
                if(tmp.charAt(j) == 'H')
                    board[i][j] = -1;
                else
                    board[i][j] = tmp.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        dfs(0, 0, 1);

        if(max == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(max);
        }
    }

    static void dfs(int x, int y, int depth){
        max = Math.max(max, depth);
        dp[x][y] = depth;

        for(int i = 0; i < 4; i++){
            int nx = x + (dx[i] * board[x][y]);
            int ny = y + (dy[i] * board[x][y]);

            if(0 <= nx && nx < N && 0 <= ny && ny < M){ // 경계값 검사
                if(board[nx][ny] != -1) { // 구멍이 아닐 때만 방문
                    if(visited[nx][ny]){
                        max = Integer.MAX_VALUE;
                        return;
                    }

                    if(dp[nx][ny] > depth)
                        continue;

                    visited[x][y] = true;
                    dfs(nx, ny, depth + 1);
                    visited[x][y] = false;
                }
            }
        }

    }
}
