import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] A, B, C, D, AB, CD;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            C[i] = sc.nextInt();
            D[i] = sc.nextInt();
        }

        // AB, CD의 모든 조합
        AB = new int[N * N];
        CD = new int[N * N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                AB[(i * N) + j] = A[i] + B[j];
                CD[(i * N) + j] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);
        
        long answer = 0;
        int ABT = 0;
        int CDT = CD.length - 1;
        while(ABT < N * N && 0 <= CDT){
            long sum = AB[ABT] + CD[CDT];

            if(sum == 0){
                long ABCnt = 1;
                long CDCnt = 1;
                while (ABT < (N * N) - 1 && AB[ABT] == AB[ABT + 1]){
                    ABCnt++;
                    ABT++;
                }
                while (1 <= CDT && CD[CDT] == CD[CDT - 1]){
                    CDCnt++;
                    CDT--;
                }
                answer += ABCnt * CDCnt;
            }

            if(sum >= 0){
                CDT--;
            }
            else{
                ABT++;
            }

        }

        System.out.println(answer);
    }
}
