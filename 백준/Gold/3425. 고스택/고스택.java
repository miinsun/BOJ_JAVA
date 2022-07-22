import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* BOJ - 3425 고스택*/
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> ops;
    static Stack<Long> stack;

    public static void main(String[] args) throws IOException {

        while(true){
            String s = br.readLine();

            if(s.equals("QUIT")){
                break;
            }
            else if(s.equals("") || s == "" || s == null){
                continue;
            }
            else{
                // input
                inputOp(s);
                int n = Integer.parseInt(br.readLine()); // 명령어 수
                for(int i = 0; i < n; i++){
                    long num = Long.parseLong(br.readLine());
                    if(!run(num)){
                        sb.append("ERROR").append('\n');
                    }
                    else{
                        if(stack.size() > 1 || stack.size() == 0){
                            sb.append("ERROR").append('\n');
                        }
                        else{
                            sb.append(stack.pop()).append('\n');
                        }
                    }
                }
                sb.append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    static void inputOp(String s) throws IOException {
        ops = new ArrayList<>();

        while(true){
            if(s.equals("END")) {
                ops.add("END");
                break;
            }
            else{
                ops.add(s);
            }
            s = br.readLine();
        }
    }


    static boolean run(long num){
        stack = new Stack<>();
        stack.add(num);

        for(String op : ops){
            if(op.equals("POP")){   // 스택 가장 위의 숫자를 제거
                if(stack.size() < 1)
                    return false;
                stack.pop();
            }
            else if(op.equals("INV")){
                if(1 > stack.size())
                    return false;
                long one = stack.pop();
                stack.add(one * -1);
            }
            else if(op.equals("DUP")){
                if(1 > stack.size())
                    return false;
                long one = stack.peek();
                stack.add(one);
            }
            else if(op.equals("SWP")){
                if(2 > stack.size())
                    return false;
                long one = stack.pop();
                long two = stack.pop();
                stack.add(one);
                stack.add(two);
            }
            else if(op.equals("ADD")){
                if(2 > stack.size())
                    return false;
                long one = stack.pop();
                long two = stack.pop();
                long rslt = one + two;
                if(1_000_000_000 < Math.abs(rslt)){
                    return false;
                }
                stack.add(rslt);
            }
            else if(op.equals("SUB")){
                if(2 > stack.size())
                    return false;
                long one = stack.pop();
                long two = stack.pop();
                long rslt = two - one;
                if(1_000_000_000 < Math.abs(rslt)){
                    return false;
                }
                stack.add(rslt);
            }
            else if(op.equals("MUL")){
                if(2 > stack.size())
                    return false;
                long one = stack.pop();
                long two = stack.pop();
                long rslt = one * two;
                if(1_000_000_000 < Math.abs(rslt)){
                    return false;
                }
                stack.add(rslt);
            }
            else if(op.equals("DIV")){
                if(2 > stack.size())
                    return false;
                long one = stack.pop();
                long two = stack.pop();

                if(one == 0)
                    return false;

                int cnt = 0;
                if(one < 0){
                    cnt++;
                }
                if(two < 0){
                    cnt++;
                }

                long abs = Math.abs(two) / Math.abs(one);
                if(cnt == 1){
                    stack.add(abs * -1);
                }
                else{
                    stack.add(abs);
                }
            }
            else if(op.equals("MOD")){
                if(2 > stack.size())
                    return false;

                long one = stack.pop();
                long two = stack.pop();

                if(one == 0)
                    return false;

                one = Math.abs(one);
                if(two < 0){
                    two = Math.abs(two);
                    stack.add((two % one) * -1);
                }
                else{
                    stack.add(two % one);
                }
            }
            else if(op.equals("END")){
                break;
            }
            else{   // NUM 일때
                String[] arr = op.split(" ");
                stack.add(Long.parseLong(arr[1]));
            }
        }

        return true;
    }
}
