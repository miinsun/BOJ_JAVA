/* 백준 문자열 구현 - 4659 :: 비밀번호 발음하기 */
import java.math.BigInteger;
import java.util.*;

public class Main {
	static String vowles = "aeiou";

	// 모음 검사
	static boolean haveVowle(String s) {		
		for(char c : vowles.toCharArray()) {
			if(s.contains(String.valueOf(c))) {
				return true;
			}
		}
		return false;
	}
	
	// 모음 && 자음이 3개 연달아 오는지 검사
	static boolean check3Alphabet(String s) {
		for(int i = 0; i < s.length() - 2; i++) {
			String tmp = s.substring(i, i + 3);
			if(vowles.contains(String.valueOf(tmp.charAt(0))) &&
				vowles.contains(String.valueOf(tmp.charAt(1))) &&
				vowles.contains(String.valueOf(tmp.charAt(2))))
				return true;
			else if(!vowles.contains(String.valueOf(tmp.charAt(0))) &&
					!vowles.contains(String.valueOf(tmp.charAt(1))) &&
					!vowles.contains(String.valueOf(tmp.charAt(2))))
				return true;
		}
		return false;
	}
	
	// 연속으로 같은 알파벳이 오는지 검사
	static boolean check2SameAlphabet(String s) {
		for(int i = 0; i < s.length() - 1; i++) {
			String tmp = s.substring(i, i + 2);
			if(tmp.charAt(0) == tmp.charAt(1)) {
				if(tmp.charAt(0) != 'e' && tmp.charAt(0) != 'o') {
					return true;
				}
			}
		}
		return false;

	}
	// 적합도 문장 출력
	static void printAcceptable(String s, boolean acceptable) {
		if(acceptable) {
			System.out.println("<"+ s + "> is acceptable.");
		}
		else {
			System.out.println("<"+ s + "> is not acceptable.");
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(true){			
			String s = sc.next();
			if(s.equals("end"))
				break;
			
			// 모음 검사
			if(!haveVowle(s)) {
				printAcceptable(s, false);
				continue;
			}
			
			// 자음 모음 연달아 3개가 오는지
			if(s.length() >= 3) {
				if(check3Alphabet(s)) {
					printAcceptable(s, false);
					continue;
				}
			}
			
			if(s.length() >= 2) {
				if(check2SameAlphabet(s)) {
					printAcceptable(s, false);
					continue;
				}
			}
						
			printAcceptable(s, true);
		}
		
		sc.close();
	}
}
