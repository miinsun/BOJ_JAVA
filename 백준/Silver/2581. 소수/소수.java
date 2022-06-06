/* 백준 기본 수학 2 - 2581 :: 소수 */
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
		int m = sc.nextInt();
		
		int total = 0;
		int min = 10000;
		for(int i = n; i <= m; i++) {
			if(isDecimal(i)) {
				min = Math.min(min, i);
				total += i;
			}
		}
		
		if(total != 0) {
			System.out.println(total);
			System.out.println(min);
		}
		else {
			System.out.println(-1);
		}
		
		sc.close();
	}
}
