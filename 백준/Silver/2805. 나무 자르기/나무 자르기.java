/* 백준 그래프 - 2805 :: 나무 자르기 */

import java.util.*;
import java.io.*;

public class Main {	
	static public long count (int[] arr, long mid) {
		long total = 0;
		
		// mid로 나눴을 때, 남는 값의 합
		for(int x : arr) {
			if(x - mid > 0)
				total += x - mid;
		}
		return total;
	}
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		// 나무의 수
		int n = sc.nextInt();
		// 집으로 가져갈 나무 길이
		int m = sc.nextInt();
		
		// 나무 정보 입력
		int [] arr = new int [n];
 		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
 		
 		// 배열 정렬, lt,rt 초기화
 		Arrays.sort(arr);
 		long lt = 1;
 		long rt = arr[n-1];
 		long answer = 0;
 		
 		// 이분 탐색 (결정 알고리즘)
		while(lt <= rt) {
			long mid = (lt + rt) / 2;
			// count()는 유효값을 찾는 함수
			if(count(arr, mid) >= m) {
				answer = mid;
				// 최대값을 찾기 때문에 유효값을 찾으면 범위를 넓혀준다.
				lt = mid + 1;
			}
			else
				rt = mid - 1;
		}
		
		System.out.println(answer);
		sc.close();
	}
}