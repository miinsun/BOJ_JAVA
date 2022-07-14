import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dice = new int[6];
    static int[][] board;

    static void copyMap(int x, int y){
        if(board[x][y] == 0){
            board[x][y] = dice[5];
        }
        else{
            dice[5] = board[x][y];
            board[x][y] = 0;
        }
    }

    static void moveDice(int cmd){
        int tmp = dice[0];
        switch (cmd){
            // 동쪽이동
            case 1:
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = tmp;
                break;
            // 서쪽이동
            case 2:
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = tmp;
                break;
            // 북쪽이동
            case 3:
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = tmp;
                break;
            // 남쪽이동
            case 4:
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = tmp;
                break;
        }
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 지도의 세로 크기
        int m = sc.nextInt();   // 지도의 가로 크기
        int x = sc.nextInt();   // 주사위의 좌표
        int y = sc.nextInt();
        int k = sc.nextInt();   // 명령의 개수

        // 지도 입력
        board = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = sc.nextInt();
            }
        }

        // 명령 실행
        for(int i = 0; i < k; i++){
            // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
            int cmd = sc.nextInt();

            int nx = x + dx[cmd - 1];
            int ny = y + dy[cmd - 1];

            // 경계값 검사
            if(nx >= n || nx < 0 || ny >= m || ny < 0)
                continue;

            // 주사위 이동
           moveDice(cmd);

            // 주사위 & 지도 값 복사
            copyMap(nx, ny);

            sb.append(dice[0]).append('\n');

            // 주사위의 좌표 갱신
            x = nx;
            y = ny;
        }

        System.out.print(sb);
    }
}
