import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] data;

    static boolean isGoodShare(int mid){
        int budget = M;
        for(int i = 0; i < N; i++){
            if(data[i] <= mid){
                budget -= data[i];
            }
            else{
                budget -= mid;
            }
        }

        return budget >= 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int lt = 0;
        int rt = M;
        data = new int[N];
        for(int i = 0; i < N; i++){
            data[i] = sc.nextInt();
            rt = Math.max(rt, data[i]);
        }
        M = sc.nextInt();

        while(lt <= rt){
            int mid = (lt + rt) / 2;  // 상한가

            if(isGoodShare(mid)){   // 상한가가 적합했으면, 상한가를 올리기
                lt = mid + 1;
            }
            else{   // 상한가가 적합하지 않았으면, 상한가를 줄이기
                rt = mid - 1;
            }
        }

        int answer = 0;
        System.out.println(rt);
    }
}
