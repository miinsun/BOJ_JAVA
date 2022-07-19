import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] =  sc.nextInt();
        }
 
        int count =0;
        long sum = 0;
        int left=0, right=0;
        while (true){
            if(sum >= m){
                sum -= arr[left++];
 
            }else if(right ==n){
                break;
            }
            else {
                sum += arr[right++];
            }
 
            if(sum == m){
                count++;
            }
 
        }
 
        System.out.println(count);
    }
}