/* 백준 투포인터 - 1806 :: 부분합 */
import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		
		int[] arr = new int [n + 1];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int lt = 0, rt = 0;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		while(lt <= n && rt <= n) {
			if(sum >= s && min > rt - lt)
				min = rt - lt;
			
			if(sum < s) 
				sum += arr[rt++];
			else 
				sum -= arr[lt++];
		}
		
		if(min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
        sc.close();
	}
}