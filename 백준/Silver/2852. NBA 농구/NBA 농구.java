/* 백준 문자열 구현 - 2892 :: NBA 농구 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t,ntime,time,t_a,t_b,s;
		boolean chk;
		s = time = t_a = t_b = 0;
		t = Integer.parseInt(br.readLine());
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			chk = st.nextToken().equals("1")?true:false;
			String str = st.nextToken();
			ntime = (str.charAt(0)-'0')*600;
			ntime += (str.charAt(1)-'0')*60;
			ntime += (str.charAt(3)-'0')*10;
			ntime += str.charAt(4)-'0';
			if(s>0) t_a += ntime - time;
			if(s<0) t_b += ntime - time;
			s += chk?1:-1;
			time = ntime;
		}
		if(s>0) t_a += 2880 - time;
		if(s<0) t_b += 2880 - time;
		System.out.printf("%02d:%02d\n%02d:%02d\n",t_a/60,t_a%60,t_b/60,t_b%60);
	}
}
