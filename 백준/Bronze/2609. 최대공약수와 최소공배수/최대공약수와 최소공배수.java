/* 백준 기초 수학  - 2609 :: 최대공약수와 최소공배수 */
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int max = 0;

		for(int i = 1; i <= Math.min(a, b); i++) {
			if(a % i == 0 && b % i == 0) {
				max = i;
			}
		}
		System.out.println(max);
		System.out.println(a * b / max);

		sc.close();
	}
}
