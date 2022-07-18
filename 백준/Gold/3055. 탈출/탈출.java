import java.util.*;

class Point{
    int x;
    int y;
    char type;

    Point(int x, int y, char type){
        this.x = x;
        this.y = y;
        this.type = type;
    }

}

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int R, C;
    static Point S, D;
    static char[][] board;
    static int[][] dp;
    static Queue<Point> queue = new LinkedList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        board = new char [R][C];
        dp = new int [R][C];
        queue = new LinkedList<>();

        for(int i = 0; i < R; i++){
            String s = sc.next();
            for(int j = 0; j < C; j++){
                // 물이면
                if(s.charAt(j) == '*') {
                    queue.add(new Point(i, j, '*'));
                }
                // 고슴도치의 시작점이라면
                else if (s.charAt(j) == 'S') {
                    S = new Point(i, j, 'S');
                }

                board[i][j] = s.charAt(j);
            }
        }

        queue.add(S);
        boolean foundAnswer = false;
        // Queue[ *, S ] 순으로 들어옴
        while(!queue.isEmpty()){
            //1. 큐에서 꺼내옴 -> *, S, ., D
            Point p = queue.poll();

            //2. 목적지인가 -> D
            if(p.type == 'D'){
                foundAnswer = true;
                System.out.println(dp[p.x][p.y]);

                break;
            }


            //3. 연결된 곳을 순회 -> 좌오 위 아래
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                //4-1. 갈 수 있는가? (공통) -> 맵안에 들어오는가
                if(0 <= nx && nx < R && 0 <= ny && ny < C){
                    //4-2.갈 수 있는가? (고슴도치) : . or D, 방문하지 않은 곳
                    if(p.type == 'S' || p.type == '.'){
                        if((board[nx][ny] == '.' || board[nx][ny] == 'D') && dp[nx][ny] == 0){
                            //5-1. 체크인 (고슴도치) : dp[][] = 이동거리
                            dp[nx][ny] = dp[p.x][p.y] + 1;
                            //6. 큐에 넣음
                            queue.add(new Point(nx, ny, board[nx][ny]));
                        }
                    }
                    //4-3. 갈 수 있는가? (물) : ., S
                    else if(p.type == '*'){
                        if(board[nx][ny] == '.' || board[nx][ny] == 'S'){
                            //5-2. 체크인 (물) : map[][] = *
                            board[nx][ny] = '*';
                            //6. 큐에 넣음
                            queue.add(new Point(nx, ny, '*'));
                        }
                    }
                }
            }
        }

        if(!foundAnswer){
            System.out.println("KAKTUS");
        }

    }
}
