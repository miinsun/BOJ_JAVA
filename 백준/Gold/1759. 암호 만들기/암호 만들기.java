import java.util.*;

public class Main {
    static int L, C;
    static char[] list;
    static char[] word;

    static void dfs(int cur, int depth){
        if(depth == L){
            int mo = 0;
            int ja = 0;
            
            for(char c : word){
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    mo++;
                }
                else
                    ja++;
            }
            
            if(mo < 1 || ja < 2)
                return;
            else{
                System.out.println(word);
            }
            
            return;
        }

        for(int i = cur; i < C; i++){
            word[depth] = list[i];
            dfs(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         L = sc.nextInt();  // 사용할 문자의 수
         C = sc.nextInt();  // 사용할 알파벳의 모음

         list = new char[C];
         word = new char[L];

         for(int i = 0; i < C; i++){
             list[i] = sc.next().charAt(0);
         }

         Arrays.sort(list);

         dfs(0,0);

    }
}
