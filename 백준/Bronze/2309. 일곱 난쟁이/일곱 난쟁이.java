/* 백준 구현 - 2309 :: 일곱 난쟁이 */
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args)throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int[] dwarf = new int[9];
    	int sum = 0;
    	
    	for(int i = 0; i < 9; i++) {
    		dwarf[i] = sc.nextInt();
    		sum += dwarf[i];
    	}
    	
    	Arrays.sort(dwarf);
    	
    	for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if(i == j) continue; 
				if (sum - dwarf[i] - dwarf[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (i == k || j == k) {
							continue;
						}
						System.out.println(dwarf[k]);
					}
					System.exit(0);
				}
			}
		}
    }
}