/* 백준 - 10988 :: 팰린드롬인지 확인하기 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		String s = sc.next();
		
		String r = "";
		for(int i = s.length() - 1; i >= 0; i--) {
			r += s.charAt(i);
		}
		
		if(s.equals(r))
			System.out.println(1);
		else
			System.out.println(0);
		
        sc.close();
	}
}