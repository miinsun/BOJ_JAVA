/* 백준 구현 - 2693 :: N번째 큰수 */
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args)throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	
    	for(int i = 0; i < t; i++) {
    		int[] arr = new int[10];
    		for(int j = 0; j < 10; j++) {
    			arr[j] = sc.nextInt();
    		}
    		Arrays.sort(arr);
    		System.out.println(arr[7]);
    	}
    }
}