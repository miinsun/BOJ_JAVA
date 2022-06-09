/* 백준 정렬 - 18870 :: 좌표 압축 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		int [] sort = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sort[i] = sc.nextInt();
		}
		
		Arrays.sort(sort);
		
		int rank = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : sort) {
			if(!map.containsKey(i)) {
				map.put(i, rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : arr)
			sb.append(map.get(i) + " ");
		
		System.out.println(sb);
		
		sc.close();
	}
}
