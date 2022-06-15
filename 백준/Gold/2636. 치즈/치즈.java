/* 백준 BFS - 2636 :: 치즈 */
import java.util.*;
import java.io.*;

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main{
    static int[][] board;
    static boolean[][] visited;
    static final int dx[] = {-1, 0, 1, 0};  //상하좌우 방향 설정
    static final int dy[] = {0, 1, 0, -1};  //상화좌우 방향 설정
    static int n, m;
    
	public static void main(String[] args)throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // 지도 입력 받기
        board = new int[n][m];
        int cheese = 0;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < m; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        		
        		// 갖고 있는 치즈의 총합
        		if(board[i][j] == 1) {
        			cheese++;
        		}
        	}
        }

        int h = 0;
        int lastCheese = 0;
        // 모든 치즈가 녹을 때까지 반복
        while(cheese != 0) {
        	h++;
        	lastCheese = cheese;
        	
        	Queue<Point> q = new LinkedList<>();
    		visited = new boolean[n][m];
    		
    		q.add(new Point(0, 0));
    		visited[0][0] = true;
    		while (!q.isEmpty()) {
    			Point tmp = q.poll();
    			for (int i = 0; i < 4; i++) {
    				int nx = tmp.x + dx[i];
    				int ny = tmp.y + dy[i];
    				
    				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])
    					continue;
    				if (board[nx][ny] == 1) {
    					cheese--;
    					board[nx][ny] = 0;
    				} else if (board[nx][ny] == 0) {
    					q.offer(new Point(nx, ny));
    				}
    				visited[nx][ny] = true;
    			}
    		}
        }
 
        System.out.println(h);
        System.out.println(lastCheese);
	}
}