import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ - 2580 스도쿠 */
public class Main {
    static int[][] board = new int [10][10];
    static boolean[][] row = new boolean[10][10];
    static boolean[][] col = new boolean[10][10];
    static boolean[][] square = new boolean[10][10];
    static int limit = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++ ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] != 0){
                    row[i][board[i][j]] = true;
                    col[j][board[i][j]] = true;
                    square[square(i, j)][board[i][j]] = true;
                }
            }
        }

        dfs(0);
    }

    static void dfs(int cnt){
        if(cnt == 81){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(board[i][j] +" ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        int x = cnt / 9;
        int y = cnt % 9;
        if(board[x][y] != 0){
            dfs(cnt + 1);
        }
        else{
            for(int i = 1; i <= 9; i++){
                if(!row[x][i] && !col[y][i] && !square[square(x, y)][i]){
                    row[x][i] = true;
                    col[y][i] = true;
                    square[square(x,y)][i] = true;

                    board[x][y] = i;
                    dfs(cnt + 1);
                    board[x][y] = 0;

                    row[x][i] = false;
                    col[y][i] = false;
                    square[square(x,y)][i] = false;
                }
            }
        }
    }

    static int square(int x, int y){
        return (x/3)*3 + (y / 3);
    }
}
