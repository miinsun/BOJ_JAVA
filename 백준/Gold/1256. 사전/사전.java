import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* BOJ - 1256 사전 */
public class Main {
    static int N, M, K;
    static int[][] dp = new int[201][201];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 'a'의 개수
        M = Integer.parseInt(st.nextToken());   // 'z'의 개수
        K = Integer.parseInt(st.nextToken());   // 몇번째 문자열인지

        if(combination(N+M, M) < K){
            System.out.println(-1);

        }
        else{
            query(N, M, K);
            System.out.println(sb.toString());
        }

    }

    public static void query(int n, int m, int k){
        // 단어 끝에 도달
        if(n == 0 && m == 0){
            return;
        }
        // z만 남은 경우
        else if(n == 0){
            sb.append('z');
            query(n, m - 1, k);
        }
        // a만 남은 경우
        else if(m == 0){
            sb.append('a');
            query(n - 1, m, k);
        }
        // a,z 둘다 남은 경우 a를 고를 때 조합 수를 보고 판단
        else{
            // 'a'를 고를때
            int leftCount = combination(n + m - 1, m);
            // int leftCount = dp[n + m -1][m];
            if(leftCount >= k){
                sb.append('a');
                query(n - 1, m, k);
            }
            else{
                sb.append('z');
                query(n, m - 1, k - leftCount);
            }
        }
    }

    // 파스칼 삼각형 만들기
    public static int combination(int n, int r){
        if(n == r || r == 0){
            return 1;
        }
        else if(dp[n][r] != 0){
            return dp[n][r];
        }
        else{
            return dp[n][r] = Math.min((int) 1e9, combination(n - 1, r - 1) + combination(n - 1, r));
        }
    }
}
