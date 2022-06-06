/* 백준 재귀 - 10870 :: 피보나치 수 5 */
import java.io.*;
import java.util.*;

public class Main {
	public static int fibo(int n) {
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		
		return fibo(n - 1) + fibo(n - 2);
	}
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fibo(n));
		sc.close();
	}
}
