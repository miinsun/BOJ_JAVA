import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int caseCnt = 1;
        boolean isEnd = false;
        HashMap<Integer, Integer> tree = new HashMap();
        int edge = 0;
        while(!isEnd){
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 정지
            if(a == -1 && b == -1){
                isEnd = true;
                break;
            }

            // tree 초기화 & tree 판별
            if(a == 0 && b == 0){
                boolean isTree = true;
                int zeroCnt = 0;

                for(int cur : tree.values()){
                    if(cur == 0){
                        zeroCnt++;
                    }
                    // 루트 제외 모든 노드들이 들어오는 간선이 하나 있다.
                    else if(cur > 1){
                        isTree = false;
                        break;
                    }
                }

                // 루트가 있어야한다 -> 들어오는 간선이 없는 단하나의 노드가 존재한다.
                if(zeroCnt != 1){
                    isTree = false;
                }

                // 정점의 개수 - 1 == 간선의 개수이다
                if(edge != tree.size() - 1){
                    isTree = false;
                }

                if(isTree || tree.size() == 0){
                    System.out.println("Case " + caseCnt + " is a tree.");
                }
                else{
                    System.out.println("Case " + caseCnt + " is not a tree.");
                }

                tree = new HashMap<>();
                edge = 0;
                caseCnt++;
                continue;
            }

            edge++;

            tree.put(a, tree.getOrDefault(a, 0));
            tree.put(b, tree.getOrDefault(b, 0) + 1);

        }
    }
}
