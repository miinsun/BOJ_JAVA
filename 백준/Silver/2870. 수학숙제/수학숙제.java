/* 백준 문자열 구현 - 2870 :: 수학숙제 */
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 단어의 개수
		
		ArrayList<BigInteger> answer = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			String tmp = "";
			for(char c : s.toCharArray()) {
				if(Character.isDigit(c)) {
					tmp += c;
				}
				else if(Character.isAlphabetic(c) && !tmp.equals("")) {
					answer.add(new BigInteger(tmp));
					tmp = "";
				}
			}
			if(!tmp.equals("")) {
				answer.add(new BigInteger(tmp));
			}
		}
		
		Collections.sort(answer);
		for(BigInteger i : answer) {
			System.out.println(i);
		}
		
		sc.close();
	}
}
