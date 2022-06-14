/* 백준 DFS - 15686 :: 치킨 배달 */
import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] board;
    static boolean[] visited;
    static int n, m;
    static ArrayList<Point> persons = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2) {
                    chickens.add(new Point(i, j));
                }
                else if(board[i][j] == 1) {
                	persons.add(new Point(i, j));
                }
            }
        }
        
        answer = Integer.MAX_VALUE;
        visited = new boolean[chickens.size()];
        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int start, int cnt) {
        if (cnt == m) {
            int res = 0;
 
            for (int i = 0; i < persons.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chickens.size(); j++) {
                    if (visited[j]) {
                        int distance = Math.abs(persons.get(i).x - chickens.get(j).x)
                                + Math.abs(persons.get(i).y - chickens.get(j).y);
 
                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            
            answer = Math.min(answer, res);
            return;
        }
 
        for (int i = start; i < chickens.size(); i++) {
            visited[i] = true;
            dfs(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}