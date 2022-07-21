import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ - 14476 최대공약수 하나 빼기
* 강사님 답안
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int[] LR = new int[N];
        int[] RL = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // LtoR 만들기
        LR[0] = nums[0];
        for (int i = 1; i < N; i++){
            LR[i] = gcd(LR[i - 1], nums[i]);
        }
        // RtoL 만들기
        RL[N - 1] = nums[N - 1];
        for(int i = N - 2; i >= 0; i--){
            RL[i] = gcd(RL[i + 1], nums[i]);
        }

        // K 선정하기
        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < N; i++){
            int gcd = 0;
            // target이 끝과 끝을 가르킬때 처리
            // target이 0일때
            if(i == 0){
                gcd = RL[1];
            }
            // target이 n-1일때
            else if(i == N - 1){
                gcd = LR[N - 2];
            }
            // target이 중간 범위에 있을 때
            else{
                gcd = gcd(LR[i - 1], RL[i + 1]);
            }

            // 나옴 값의 검증, nums[i]의 약수인가
            if(nums[i] % gcd != 0 && gcd > max){
                max = gcd;
                maxIndex = i;
            }

        }

        if(max == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(max + " " + nums[maxIndex]);
        }

    }

    static int gcd(int a, int b) {
        while (b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
