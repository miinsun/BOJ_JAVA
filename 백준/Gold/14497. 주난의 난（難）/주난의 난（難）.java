/* 백준 - 14497 :: 주난의 난 */
import java.io.*;
import java.util.*;

class Point{
	int x;
	int y;
	int cnt;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args)throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		// 주난의 위치
		int x1 = Integer.parseInt(st.nextToken()) - 1;
		int y1 = Integer.parseInt(st.nextToken()) - 1;

		// 초코바의 위치
		int x2 = Integer.parseInt(st.nextToken()) - 1;
		int y2 = Integer.parseInt(st.nextToken()) - 1;
		
		char[][] board = new char[n][m];
		int[][] visited = new int[n][m];
		for(int i = 0; i < n; i++) {
			Arrays.fill(visited[i], -1);
		}
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		Deque<Point> q = new LinkedList<>();
		q.add(new Point(x1, y1));
		visited[x1][y1] = 0;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();

			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				// 외곽선 검사
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == -1) {
					if(board[nx][ny] == '1' || board[nx][ny] == '#') {
						visited[nx][ny] = visited[cur.x][cur.y] + 1;
						q.add(new Point(nx, ny));
					}
					else if(board[nx][ny] == '0') {
						visited[nx][ny] = visited[cur.x][cur.y];
						q.addFirst(new Point(nx, ny));
					}

					
				}
			}
		}
		
		System.out.println(visited[x2][y2]);
		br.close();
		
	}
}
