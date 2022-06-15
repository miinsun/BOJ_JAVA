/* 백준 BFS - 2589 :: 보물섬 */
import java.util.*;
import java.io.*;

class Point {
	int x;
	int y;
	int cost;
	
	Point(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}

public class Main{
    static char[][] board;
    static final int dx[] = {0,0,1,-1};  //상하좌우 방향 설정
    static final int dy[] = {1,-1,0,0};  //상화좌우 방향 설정
    static int n, m;
	public static void main(String[] args)throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // 지도 입력 받기
        board = new char[n][m];
        for(int i = 0; i < n; i++) {
        	String s = br.readLine();
        	for(int j = 0; j < m; j++) {
        		board[i][j] = s.charAt(j);
        	}
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(board[i][j] == 'L')
        			max = Math.max(max, bfs(i, j));
        	}
        }
        
        System.out.println(max);
    }
	
	static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];

		q.add(new Point(x, y, 0));
		visited[x][y] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < m 
						&& board[nx][ny] == 'L' && !visited[nx][ny]) {
					q.add(new Point(nx, ny, tmp.cost + 1));
					visited[nx][ny] = true;
					cnt = Math.max(cnt, tmp.cost + 1);
				}
			}
		}
		
		return cnt;
	}
}