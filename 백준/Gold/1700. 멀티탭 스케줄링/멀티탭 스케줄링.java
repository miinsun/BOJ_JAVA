/* 백준 그리디 - 1700 :: 멀티탭 */
import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] list = new int[k];
		for(int i = 0; i < k; i++) {
			
			list[i] = sc.nextInt();
		}
		
		// 멀티탭 초기 설정
		int[] multitap = new int[n];
		int index = 0, mtIndex = 0;
		while(mtIndex < n) {
			boolean isIn = false;
			for(int j = 0; j < n; j++) {
				if(multitap[j] == list[index]) {
					isIn = true;
					break;
				}
			}
			if(!isIn) {
				multitap[mtIndex++] = list[index];
			}
			index++;
		}

		int answer = 0;
		for(int i = index; i < k; i++) {
			boolean isIn = false;
			for(int j = 0; j < n; j++) {
				if(multitap[j] == list[i]) {
					isIn = true;
					break;
				}
			}
			
			int maxIndex = 0;
			// 멀티탭에 없는 기구면, 교환해주기
			if(!isIn) {
				int max = 0;
				for(int j = 0; j < n; j++) {
					int len = 0;
					for(int l = i; l < k; l++) {
						if(multitap[j] == list[l]) {
							len = l - i;
							break;
						}
					}
					
					if(len == 0)
						len = Integer.MAX_VALUE;
					
					if(max <= len) {
						max = len;
						maxIndex = j;
					}
				}
				multitap[maxIndex] = list[i];
				answer++;
			}
		}
		
		System.out.println(answer);
        sc.close();
	}
}