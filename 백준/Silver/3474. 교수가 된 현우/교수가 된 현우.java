/* 백준 그리디 - 3474 :: 교수가 된 현우 */
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
				
		for(int i = 0; i < t; i++) {
			int num5 = 0;
			long num = sc.nextLong();
			for(int j = 5; j <= num; j *= 5) {
				num5 += num / j;
			}
			System.out.println(num5);
			
		}
		
		
		sc.close();
	}
}
