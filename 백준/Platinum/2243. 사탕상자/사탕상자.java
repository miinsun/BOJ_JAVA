import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/* BOJ - 2243 사탕상자*/
public class Main {
    static int S;
    static int MAX = 1000000;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        S = 1;
        while(S < MAX){
            S *= 2;
        }
        tree = new int[2 * S];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 카운팅 Query, 사탕 빼기
            if(a == 1){
                int index = query(1, S, 1, b);
                update(1, S, 1, index, -1);
                System.out.println(index);
            }
            // 삽입, 사탕 넣기
            else{
                int c = Integer.parseInt(st.nextToken());
                update(1, S, 1, b, c);
            }
        }
    }

    static int query(int left, int right, int node, int count){
        // 1. Leaf에 도착했을 때 -> 사탕 번호 반환
        if(left == right){
            return left;
        }
        else{
            int mid = (left + right) / 2;
            // 2. 왼쪽 자식 >= count -> 왼쪽으로 이동
            if(tree[node * 2] >= count){
                return query(left, mid, node * 2, count);
            }
            // 3. 왼쪽 < count -> 오른쪽으로 이동
            else{
                // 왼쪽 자식만큼 카운트를 배제
                count -= tree[node * 2];
                return query(mid + 1, right, node * 2 + 1, count);
            }
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
