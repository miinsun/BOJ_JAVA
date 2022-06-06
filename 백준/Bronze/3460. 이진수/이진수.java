/* 백준 구현 - 3460 :: 이진수 */
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
        	int n = Integer.parseInt(br.readLine());
        	String s = Integer.toBinaryString(n);
        	
        	for(int j = s.length() - 1; j >= 0; j--) {
        		if(s.charAt(j) == '1')
        			System.out.print(Math.abs(j - (s.length() - 1)) + " ");
        	}
        }

    }
}