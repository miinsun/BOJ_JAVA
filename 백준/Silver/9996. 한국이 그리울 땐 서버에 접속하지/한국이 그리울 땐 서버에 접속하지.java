/* 백준 - 9996 :: 한국이 그리울 땐 서버에 접속하지 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();	// 파일의 개수
		String[] pattern = sc.next().split("\\*"); // pattern[0]은 앞부분, pattern[1]은 뒷부분

		for(int i = 0; i < n; i++) {
			String s = sc.next();
			
			if(s.length() < pattern[0].length() + pattern[1].length()) {
				System.out.println("NE");
			}
			else {
				if(pattern[0].equals(s.substring(0, pattern[0].length()))// 앞부분 비교
						&& pattern[1].equals(s.substring(s.length() - pattern[1].length())))// 뒷부분 비교
					System.out.println("DA");
				else
					System.out.println("NE");
				
			}
			
		}
		
		
        sc.close();
	}
}