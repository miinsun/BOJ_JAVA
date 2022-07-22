import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ - 1722 순열의 순서 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] fact = new long[21];
        fact[0] = 1;
        for(int i = 1; i <= 20; i++){
            fact[i] = fact[i - 1] * i;
        }

        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cmd = Integer.parseInt(st.nextToken());
        if(cmd == 1){
            long target = Long.parseLong(st.nextToken());
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++){
                for(int j = 1; j <= N; j++){
                    if(!visited[j]){
                        if(target > fact[N - i - 1]){
                            target -= fact[N - i - 1];
                        }
                        else{
                            sb.append(j).append(" ");
                            visited[j] = true;
                            break;
                        }
                    }
                }
            }
            System.out.println(sb.toString());
        }
        else{
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            for(int i = 0; i < N; i++){
                for(int j = 1; j < arr[i]; j++){
                    if(!visited[j]){
                        result += fact[N - i - 1];
                    }
                }
                visited[arr[i]] = true;
            }
            System.out.println(result + 1);
        }
    }
}
