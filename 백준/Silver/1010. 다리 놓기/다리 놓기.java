import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] answer= new double[sc.nextInt()];
		
		for(int i = 0; i < answer.length; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			double p = 1;
			double q = 1;		
			for(double j = m; j > (m - n); j--){
	            p *= j;
	        }
			
			for(double j = 2; j <= n; j++){
	            q *= j;
	        }
			answer[i] = p / q;
		}

		for(double num : answer) {
			System.out.printf("%.0f\n", num);
		}
			
		sc.close();
	}
}
