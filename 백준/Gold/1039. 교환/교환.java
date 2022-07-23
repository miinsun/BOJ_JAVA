import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Num{
    int num;
    int depth;

    public Num(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}

/* BOJ - 1039 교환 */
public class Main {
    static int N, K;
    static boolean[][] visited;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean [K + 1][1000001];

        bfs();

        System.out.println(max);
    }

    static void bfs(){
        Queue<Num> q = new LinkedList<>();

        q.add(new Num(N, 0));
        visited[0][N] = true;

        while(!q.isEmpty()){
            Num cur = q.poll();

            if(cur.depth == K){
                max = Math.max(cur.num, max);
            }
            else {
                int len = String.valueOf(cur.num).length();
                for (int i = 0; i < len - 1; i++) {
                    for (int j = i + 1; j < len; j++) {
                        int swapNum = swap(cur.num, i, j);
                        if (swapNum != -1 && !visited[cur.depth + 1][swapNum]) {
                            q.add(new Num(swapNum, cur.depth + 1));
                            visited[cur.depth + 1][swapNum] = true;
                        }
                    }
                }
            }
        }
    }

    static int swap(int num, int s, int e){
        char[] numArr = String.valueOf(num).toCharArray();

        char tmp;
        tmp = numArr[s];
        numArr[s] = numArr[e];
        numArr[e] = tmp;

        if(numArr[0] == '0')
            return -1;
        else
            return Integer.parseInt(new String(numArr));
    }
}
