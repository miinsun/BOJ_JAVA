import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Jewel{
    int m; // 무게
    int v; // 가격

    public int getM() {
        return m;
    }

    public int getV() {
        return v;
    }

    public Jewel(int m, int v) {
        this.m = m;
        this.v = v;
    }
}
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 보석의 수
        int K = Integer.parseInt(st.nextToken());   // 가방의 랙

        Jewel[] jewelries = new Jewel[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewel(m, v);
        }


        int[] bags = new int[K];
        for(int i = 0; i < K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 가방 오름차 정렬
        Arrays.sort(bags);
        // 보석 무게 오름차 정렬
        Arrays.sort(jewelries, Comparator.comparingInt(Jewel :: getM));
        // 보석 가격이 높은 값 기준 합
        PriorityQueue<Jewel> pq = new PriorityQueue<>(Comparator.comparingInt(Jewel::getV).reversed());

        int jIndex = 0;
        long answer = 0;
        // 1. 남은 가방 중 제일 작은 가방을 선택
        for(int i = 0; i < K; i++){
            // 2. 선택된 가방에 넣을 수 있는 남은 보석 중 가장 비싼 보석을 선택 <- 힙을 사용
            while(jIndex < N && jewelries[jIndex].m <= bags[i]){
                pq.add(jewelries[jIndex++]);
            }
            if(!pq.isEmpty()){
                answer += pq.poll().v;
            }
        }

        System.out.println(answer);
    }
}
