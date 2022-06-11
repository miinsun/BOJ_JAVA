/* 백준 - 2468 :: 안전 영역 */
import java.util.*;

import java.io.*;
class Point {
	public int x, y;
	Point (int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] board, safe;
	static Queue<Point> q = new LinkedList<>();
	
	public static void bfs(int height, int cnt) {				
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				if(nx >= 0 && nx < board.length && ny >= 0 && ny < board.length 
						&& board[nx][ny] > height && safe[nx][ny] == 0) {
					q.offer(new Point(nx, ny));
					safe[nx][ny] = cnt;
				}
			}
		}
 	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		
		int maxHeight = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, board[i][j]);
			}
		}
		
		int answer = 0;
		for(int i = 0; i < maxHeight; i++) {					// 물이 차오르는 높이
			safe = new int[n][n];
			int cnt = 1;
			for(int j = 0; j < n; j++) {						// x좌표
				for(int k = 0; k < n; k++) {					// y좌표
					if(board[j][k] > i && safe[j][k] == 0) {	// 방문한적이 없고, 물이 차오르는 높이보다 높은 지점만 방문
						q.offer(new Point(j, k));
						bfs(i, cnt);
						answer = Math.max(answer, cnt);
						cnt++;
					}
				}
			}
		}
		
		System.out.println(answer);
		
        br.close();
	}
}