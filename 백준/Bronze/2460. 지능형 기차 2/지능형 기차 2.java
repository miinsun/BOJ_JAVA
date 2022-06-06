/* 백준 구현 - 2460 :: 지능형 기차 2 */
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        int max = 0;
        int people = 0;
        for(int i = 0; i < 10; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	people -= Integer.parseInt(st.nextToken());
        	people += Integer.parseInt(st.nextToken());
        	
        	max = Math.max(max, people);
        }

        System.out.println(max);
    }
}