import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        init();
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 합집합
            if(op == 0){
                union(a, b);
            }
            // find
            else{
                if(find(a) == find(b)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }

    static void init(){
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }
    }
    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        parent[aRoot] = bRoot;
    }

    static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
