/* 백준 그리디  - 10709 :: 기상캐스터 */
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();	// 지역의 높이
		int w = sc.nextInt();	// 지역의 넓이

		char[][] board = new char[h][w];
		int[][] answer = new int[h][w];
		for(int[] tmp : answer) {
			Arrays.fill(tmp, -1);
		}
		
		for(int i = 0; i < h; i++) {
			String s = sc.next();
			for(int j = 0; j < w; j++) {
				board[i][j] = s.charAt(j);
				if(board[i][j] == 'c')
					answer[i][j] = 0;
			}
		}
		
		
		for(int i = 0; i < h; i++) {
			for(int j = 1; j < w; j++) {
				if(answer[i][j - 1] != -1 && answer[i][j] != 0) {
					answer[i][j] = answer[i][j - 1] + 1;
				}
			}
		}
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
