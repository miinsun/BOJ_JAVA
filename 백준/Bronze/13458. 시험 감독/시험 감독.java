import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tester = new int [n];

        // 응시자 수 입력
        for(int i = 0; i < n; i++){
            tester[i] = sc.nextInt();
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        long answer = 0;
        for(int i = 0; i < n; i++){
            // 총 감독관 한명씩 배치
            if(a < tester[i]){
                tester[i] -= a;

                // 부 감독관 배치
                answer += (tester[i] / b);
                if(tester[i] % b != 0){
                    answer++;
                }
            }
            answer++;
        }

        System.out.println(answer);
    }
}
