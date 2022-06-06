/* 백준 구현 - 2501 :: 약수 구하기 */
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int i = 1;
        while(true) {
        	if(n % i == 0)
        		k--;
        	if(i == n || k == 0)
        		break;
        	i++;
        }
        
        if(k == 0)
        	System.out.println(i);
        else
        	System.out.println(0);
    }
}