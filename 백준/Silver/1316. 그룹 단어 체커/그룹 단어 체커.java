/* 백준 - 1316 :: 그룹 단어 체커 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			String tmp = "";
			
			boolean isGroupWord = true;
			if(s.length() > 2) {
				tmp = s.substring(0, 2);
				for(int j = 2; j < s.length(); j++) {
					if(tmp.contains(String.valueOf(s.charAt(j))) 
							&& tmp.charAt(j - 1) != s.charAt(j)) {
						isGroupWord = false;
						break;
					}
					tmp += s.charAt(j);
				}
			}
			
			if(isGroupWord)
				answer++;
		}
		
		System.out.println(answer);
		
        sc.close();
	}
}