import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K, S;
    static long[] nums, tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N];

        for(int i = 0; i < N; i++){
            nums[i] = Long.parseLong(br.readLine());
        }

        S = 1;
        while(S < N){
            S *= 2;
        }

        tree = new long[S * 2];

        initBU();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            // a가 1이면 b번째 수를 c로 바꾸고
            if(a == 1){
                update(1, S, 1, b, c - nums[b - 1]);
                nums[b-1] = c;
                tree[S+b-1] = c;
            }
            // a가 2인 경우 b부터 c까지의 합을 구함
            else{
                sb.append(query(1, S, 1, b, c)).append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    static void initBU() {
        // Leaf에 값 반영
        for (int i = 0; i < N; i++) {
            tree[S + i] = nums[i];
        }
        // 내부노드 채움
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static long query(int left, int right, int node, int queryLeft, long queryRight) {
        // 연관이 없음 -> 결과에 영향이 없는 값 return
        if (queryRight < left || right < queryLeft) {
            return 0;
        }
        // 판단 가능 -> 현재 노드 값 return
        else if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        // 판단불가, 자식에게 위임, 자식에서 올라온 합을 return
        else {
            int mid = (left + right) / 2;
            long resultLeft = query(left, mid, node * 2, queryLeft, queryRight);
            long resultRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return resultLeft + resultRight;
        }
    }

    static void update(int left, int right, int node, int target, long diff) {
        //연관없음
        if (target < left || right < target) {
            return;
        }
        //연관 있음 -> 현재 노드에 diff 반영 -> 자식에게 diff전달
        else {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }
}
