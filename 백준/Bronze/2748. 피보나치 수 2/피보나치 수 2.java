import java.util.Scanner;

/*
* 백준 2748 피보나치 수 2
* 시간 복잡도
*/
public class Main {
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] dp = new long[91];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N]);
    }
}
