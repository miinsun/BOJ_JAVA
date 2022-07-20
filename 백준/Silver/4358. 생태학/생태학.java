import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();

        int cnt = 0;
        while(sc.hasNextLine()){
            String name = sc.nextLine();

            map.put(name, map.getOrDefault(name, 0) + 1);
           cnt++;
        }

        Object[] names = map.keySet().toArray();
        Arrays.sort(names);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < names.length; i++){
           double per = (double) (map.get(names[i]) * 100) / cnt;
           sb.append(names[i] + " " + String.format("%.4f", per)).append('\n');
        }

        System.out.println(sb.toString());
    }
}
