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
	static char[][] board;
	static int n,m;
	
	public static void bfs(int x, int y, int[][] checked) {

		Deque<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		checked[x][y] = 1;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();

			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				// 외곽선 검사
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && checked[nx][ny] == 0) {
					if(board[nx][ny] == '1' || board[nx][ny] == '#') {
						checked[nx][ny] = checked[cur.x][cur.y] + 1;
						q.add(new Point(nx, ny));
					}
					else if(board[nx][ny] == '0') {
						checked[nx][ny] = checked[cur.x][cur.y];
						q.addFirst(new Point(nx, ny));
					}

					
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		// 주난의 위치
		int x1 = Integer.parseInt(st.nextToken()) - 1;
		int y1 = Integer.parseInt(st.nextToken()) - 1;

		// 초코바의 위치
		int x2 = Integer.parseInt(st.nextToken()) - 1;
		int y2 = Integer.parseInt(st.nextToken()) - 1;
		
		// 교실 정보 입력
		board = new char[n][m];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		// 주난이의 점프 결과를 저장
		int[][] checked = new int[n][m];
		
		// 주난이의 위치를 중심으로 bfs 진행
		bfs(x1, y1, checked);
		
		System.out.println(checked[x2][y2] - 1);
		br.close();
		
	}
}
