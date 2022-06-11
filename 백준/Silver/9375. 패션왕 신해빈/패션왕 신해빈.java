/* 백준 - 9357 :: 패션왕 신해빈 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		int t = sc.nextInt();		
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			HashMap<String, Integer> map = new HashMap<>();
			for(int j = 0; j < n; j++) {
				String name = sc.next();
				String category = sc.next();
				map.put(category, map.getOrDefault(category, 0) + 1);
			}
			
			int answer = 1;
			for(int tmp : map.values()) {
				answer *= (tmp + 1);
			}
			
			System.out.println(answer - 1);
		}
        sc.close();
	}
}