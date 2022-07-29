import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int T, N;
    static int[][][] dp;
    static int[] data;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        // 테스트 케이스 반복
        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());

            data = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                data[j] = Integer.parseInt(st.nextToken());
            }

            dp = new int[2][N + 1][N + 1];
            System.out.println(dfs(0, 1, N));
        }
    }

    static public int dfs(int player, int left, int right){
        if(left > right)
            return 0;

        if (dp[player][left][right] != 0)
            return dp[player][left][right];

        // 근우 차례
        if(player == 0){
            dp[player][left][right] = Math.max(dfs(1, left + 1, right) + data[left],
                    dfs(1, left, right - 1) + data[right]);
        }
        // 명우 차례
        else{
            dp[player][left][right] = Math.min(dfs(0, left + 1, right), dfs(0, left, right - 1));
        }

        return dp[player][left][right];
    }
}
