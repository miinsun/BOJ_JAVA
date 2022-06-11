/* 백준 BFS - 2583 :: 영역 구하기 */
import java.io.*;
import java.util.*;

class Point {
	public int x, y;
	Point (int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {	
	static boolean[][] board;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Point> q = new LinkedList<>();
	
	static int bfs(int n, int m) {
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			cnt++;

			for(int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				if(nx >= 0 && nx < m && ny >= 0 && ny < n && !board[nx][ny]) {
					q.offer(new Point(nx, ny));
					board[nx][ny] = true;
				}
			}
		}
		
		if(cnt > 1)
			cnt--;
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		board = new boolean[m][n];
		
		// 직사각형 입력받기
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			Point leftBottom = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point rightTop = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
			for(int j = leftBottom.y; j < rightTop.y; j++) {
				for(int h = leftBottom.x; h < rightTop.x; h++) {
					board[j][h] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!board[i][j]) {
					q.add(new Point(i, j));
					answer.add(bfs(n,m));
				}
			}
		}
		
		Collections.sort(answer);
		sb.append(answer.size()).append('\n');
		for(int num : answer) {
			sb.append(num + " ");
		}
		System.out.println(sb);
		br.close();
	}
}
