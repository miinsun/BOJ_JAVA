/* 백준 구현 - 1292 :: 쉽게 푸는 문제 */
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args)throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int[] arr = new int [1001];
    	
    	int index = 1;
    	int j = 1;
    	int cnt = 0;
    	while(index <= 1000) {
    		arr[index] = j;
    		cnt++;
    		
    		if(j == cnt) {
    			j++;
    			cnt = 0;
    		}
    		index++;
    	}
    	
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	int sum = 0;
    	for(int i = a; i <= b; i++) {
    		sum += arr[i];
    	}
    	System.out.println(sum);
    }
}