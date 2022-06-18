import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    // 미로
    public static char[][] maze;
    public static int row, column;
    // 네 방향으로 이동
    public static int[][] plus = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이동하는 위치 저장
        Queue<Point> queue = new LinkedList<>();
        boolean escape=false;
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        maze = new char[row][column];

        for (int x = 0; x < row; x++) {

            String temp = br.readLine();

            for (int y = 0; y < column; y++) {
                maze[x][y] = temp.charAt(y);

                if(maze[x][y]=='J' || maze[x][y]=='F')
                    queue.add(new Point(x, y));

            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int x = 0; x < size; x++) {
                Point now = queue.poll();

                // 지훈이는 탈출 할 수 있을까?
                if (isEscape(now.x, now.y)) {
                    escape = true;
                    break;
                }

                for (int idx = 0; idx < 4; idx++) {
                    int next_x = now.x + plus[idx][0];
                    int next_y = now.y + plus[idx][1];

                    if(next_x<0 || next_x>=row || next_y<0 || next_y>=column)
                        continue;

                    if ((maze[now.x][now.y] == 'F' && maze[next_x][next_y] == 'J')|| maze[next_x][next_y]=='.') {
                        queue.add(new Point(next_x, next_y));
                        maze[next_x][next_y] = maze[now.x][now.y];
                    }
                }
            }
            if(escape)
                break;

            answer++;
        }

        if(escape)
            bw.write(String.valueOf(answer + 1));
        else
            bw.write("IMPOSSIBLE");

        bw.flush();


    }

    // 지훈이가 탈출할 수 있을 것인지 판단
    public static boolean isEscape(int x, int y) {
        if (maze[x][y] == 'J') {
            if(x==0 || x==row-1 || y==0 || y==column-1)
                return true;
        }
        return false;
    }


    // 좌표 저장 클래스
    static class Point{
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}