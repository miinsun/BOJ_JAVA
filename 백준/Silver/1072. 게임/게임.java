import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/* BOJ - 1072 게임 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int cnt = -1;
        int originScore = (int)((long)Y * 100 / X);
        int left = 0;
        int right = (int) 1e9;

        while(left <= right){
            int mid = (left +right) / 2;
            int newScore = (int)((long) (Y + mid) * 100 / (X + mid));
            if(newScore != originScore){
                cnt = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(cnt);
    }
}
