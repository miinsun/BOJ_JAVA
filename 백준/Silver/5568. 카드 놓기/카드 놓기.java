import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] cards;
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        cards = new int[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            cards[i] = sc.nextInt();
        }

        dfs("",0);

        System.out.println(set.size());
    }

    public static void dfs(String num, int depth) {
        if (depth == k) {
            set.add(Integer.parseInt(num));
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(num + cards[i], depth + 1);
                visited[i] = false;
            }
        }

    }
}
