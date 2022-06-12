/* 백준 그리디  - 2828 :: 사과 담기 게임 */
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 스크린의 크기
		int m = sc.nextInt();	// 바구니의 크기
		int j = sc.nextInt();	// 떨어지는 사과의 개수
		
		int start = 1;	// 바구니의 시작위치
		int end = m;	// 바구니의 끝 위치
		int answer = 0;
		for(int i = 0; i < j; i++) {
			int apple = sc.nextInt();
			
			if(end < apple) {	// 사과가 바구니의 오른쪽에 위치할 때
				// 바구니를 오른쪽으로 이동
				answer += (apple - end);
				start = apple - m + 1;
				end = apple;
			}
			else if(start > apple) {	// 사과가 바구니의 왼쪽에 위치할때
				// 바구니를 왼쪽으로 이동
				answer += (start - apple);
				start = apple;
				end = apple + m - 1;
			}
			
		}
		
		System.out.println(answer);
		sc.close();
	}
}
