/* 백준 누적 합 - 11659 :: 구간 합 구하기 4 */
import java.util.*;
import java.io.*;

public class Main{

    static int N;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[N + 1];
        long[] sum = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	arr[i] = Long.parseLong(st.nextToken());
        	
        	if(i == 1) {
        		sum[i] = arr[i];
        	}
        	else {
        		sum[i] = sum[i - 1] + arr[i];
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	
        	if(s == 1)
        		sb.append(sum[e]).append('\n');
        	else
        		sb.append(sum[e] - sum[s - 1]).append('\n');
        }
        
        System.out.println(sb);
    }
}