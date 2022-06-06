/* 백준 기본 수학 2 - 1978 :: 소수 찾기 */
import java.util.Scanner;

public class Main {

	public static boolean isDecimal(int n) {
		if(n == 1)
			return false;
		
		for(int i = 2; i < n; i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			if(isDecimal(tmp)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
}
