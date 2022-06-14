/* 백준 DFS - 16234 :: 인구 이동 */
import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static final int dx[] = {0,0,1,-1};  //상하좌우 방향 설정
    static final int dy[] = {1,-1,0,0};  //상화좌우 방향 설정
    static int n, L, R;
    static boolean isUnion = false;
    
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        
        // 마을 정보 입력
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 이민 반복
        int cnt = 0;
        while(true) {	
            visited = new boolean[n][n];
			boolean isMove = false;

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!visited[i][j]) { // 이미 연합을 이루었던 경우는 pass 
						if(bfs(i, j)) {
							isMove = true;
						}
					}
				}
			}

			if(!isMove) {
				break;
			}
			cnt++;
		}

        System.out.println(cnt);
    }

    public static boolean bfs(int x, int y) {	    
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		ArrayList<Point> list = new ArrayList<> ();
		list.add(q.peek());
		
		visited[x][y] = true;
		int total = board[x][y];
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();

			for(int i = 0; i < 4; i++) { // 상좌하우 검사 
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
					int diff = Math.abs(board[nx][ny] - board[tmp.x][tmp.y]);
					if(diff >= L && diff <= R) {
						list.add(new Point(nx, ny));
						total += board[nx][ny];
						visited[nx][ny] = true;
						q.add(new Point(nx, ny));
					}
				}
				
			}
		}
		
		boolean isUnion = false;
		if(list.size() > 1) {
			isUnion = true;
			int result = total / list.size();
			
			for(int i = 0; i < list.size(); i++) {
				Point tmp = list.get(i);
				board[tmp.x][tmp.y] = result;
			}
		}
		
		return isUnion;
	}
}