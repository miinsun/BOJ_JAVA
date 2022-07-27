import java.util.Scanner;

public class Main {
    static int M, K;
    static int[] colors;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();   // 조약돌의 색상 개수
        int total = 0;
        colors = new int[M];
        for(int i = 0; i < M; i++){
            colors[i] = sc.nextInt();
            total += colors[i];
        }
        K = sc.nextInt();   // 뽑을 조약돌 수

        double answer = 0;
        for(int i = 0; i < M; i++){
            double per = 1;
            if(colors[i] >= K){
                for(int j = 0; j < K; j++){
                    per *= (colors[i] - j) / (double)(total - j);
                }
                answer += per;
            }
        }

        System.out.println(answer);

    }
}
