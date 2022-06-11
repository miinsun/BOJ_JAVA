/* 백준 - 2979 :: 트럭 주차 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int[] costs = new int[100];
		for(int i = 0; i < 3; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			for(int j = start; j < end; j++) {
				costs[j] = costs[j] + 1;
			}
		}
		
		int answer = 0;
		for(int i = 0; i < 100; i++) {
			if(costs[i] == 1)
				answer += a;
			else if(costs[i] == 2)
				answer += 2 * b;
			else if(costs[i] == 3)
				answer += 3 * c;
		}
		
		System.out.println(answer);
		
        sc.close();
	}
}