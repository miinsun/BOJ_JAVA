/* 백준 - 1159 :: 농구 경기 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();		
		
		int[] answer = new int [26];
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			answer[s.charAt(0) - 'a']++;
		}
		
		boolean surrender = true;
		
		for(int i = 0; i < 26; i++) {
			if(answer[i] >= 5) {
				System.out.print((char)('a' + i));
				surrender = false;
			}
		}
		
		if(surrender)
			System.out.print("PREDAJA");
        sc.close();
	}
}