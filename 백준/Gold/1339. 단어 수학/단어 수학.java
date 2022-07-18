import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] list = new String[n];
        int[] alpha = new int[26];
        for (int i = 0; i < n; i++) {
            list[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            int tmp = (int) Math.pow(10, list[i].length() - 1);
            for (int j = 0; j < list[i].length(); j++) {
                alpha[(int) list[i].charAt(j) - 'A'] += tmp;
                tmp /= 10;
            }
        }

        Arrays.sort(alpha);
        int index = 9;
        int answer = 0;
        for (int i = 25; i >= 0; i--) {
            if (alpha[i] == 0)
                break;
            answer += alpha[i] * index;
            index--;
        }

        System.out.println(answer);
    }
}
