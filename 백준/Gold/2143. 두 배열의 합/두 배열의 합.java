import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* BOJ - 2143 두 배열의 합*/
public class Main {

    static long T;
    static int N, M;
    static long[] inputA, inputB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Long.parseLong(br.readLine());

        // A 배열 입력
        N = Integer.parseInt(br.readLine());
        inputA = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputA[i] = Long.parseLong(st.nextToken());
        }

        // B 배열 입력
        M = Integer.parseInt(br.readLine());
        inputB = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            inputB[i] = Long.parseLong(st.nextToken());
        }

        // A의 누적합 구하기
        List<Long> subA = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            long sum = inputA[i];
            subA.add(sum);
            for (int j = i + 1; j < N; j++) {
                sum += inputA[j];
                subA.add(sum);
            }
        }

        // B의 누적합 구하기
        List<Long> subB = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            long sum = 0;
            for (int j = i; j < M; j++) {
                sum += inputB[j];
                subB.add(sum);
            }
        }

        Collections.sort(subA);
        Collections.sort(subB, Comparator.reverseOrder());

        long result = 0;
        int ptA = 0;
        int ptB = 0;
        while (true) {
            long currentA = subA.get(ptA);
            long target = T - currentA;

            if (subB.get(ptB) == target) {
                long countA = 0;
                long countB = 0;
                while (ptA < subA.size() && subA.get(ptA) == currentA){
                    countA++;
                    ptA++;
                }
                while (ptB < subB.size() && subB.get(ptB) == target){
                    countB++;
                    ptB++;
                }
                result += countA * countB;
            }
            else if (subB.get(ptB) > target) {
                ptB++;
            }
            else {
                ptA++;
            }

            //탈출 조건
            if (ptA == subA.size() || ptB == subB.size()) {
                break;
            }
        }

        System.out.println(result);
    }
}
