import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static LinkedHashSet<String> result = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        dfs("", 0, 0);

        result.forEach(System.out ::println);

    }

    public static void dfs(String num, int prev, int depth){
        if(depth == M){
            if(!result.contains(num))
                result.add(num);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i] && prev <= arr[i]){
                visited[i] = true;
                dfs(num + arr[i] + " ", arr[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
