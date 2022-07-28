import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();

        }

        dp = new int[N + 1];
        dp[1] = 1;
        int answer = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        int len = answer;
        Stack<Integer> stack = new Stack<>();
        for(int i = N; i >= 1; i--){
            if(len == dp[i]){
                stack.push(arr[i]);
                len--;
            }
        }

        System.out.println(answer);
        while (!stack.isEmpty()){
            System.out.printf(stack.pop() + " ");
        }
    }
}
