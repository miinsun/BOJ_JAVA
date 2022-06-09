/* 백준 다익스트라 - 1753 :: 최단경로 */
import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
	int index;			// 노드 번호
	int distacne;		// 이동 할 노드까지의 거리

	Node(int index, int distacne) {
		this.index = index;
		this.distacne = distacne;
	}
	
	@Override
	public int compareTo(Node o) {
	return Integer.compare(this.distacne, o.distacne);
	}
}

public class Main {
	static final int INF = 9999999;
	static List<List<Node>> graph = new ArrayList<>();
	static int[] result;	
		
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		
		result = new int[v + 1];
		Arrays.fill(result, INF);
		
		// 문제에서 주어진 입력 값에 따라 그래프 초기화
		for (int i = 0; i < e; i++) {
			graph.get(sc.nextInt()).add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		// 다익스트라 알고리즘 수행
		dijkstra(k);
		
		// 문제에서 제시한 조건에 맞게 출력
		for (int i = 1; i < result.length; i++) {
			if(result[i] == INF) {
				System.out.println("INF");	
			}else {
				System.out.println(result[i]);
			}
		}
        sc.close();
	}
	
	static void dijkstra(int start) {
		// 최단거리가 갱신 된 노드들을 담을 우선순위 큐 생성
		PriorityQueue<Node> pq =  new PriorityQueue<>();
		result[start] = 0;
		
		pq.offer(new Node(start, result[start]));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int nodeIndex = node.index;
			int distance = node.distacne;
			
			// 중복 방문 검사
			if(distance > result[nodeIndex]) {
				continue;
			}
			
			for (Node linkedNode : graph.get(nodeIndex)) {
				// 새로 찾은 값이 최단 거리면, 최단 거리 갱신해주기
				if(distance + linkedNode.distacne < result[linkedNode.index]) {
					result[linkedNode.index] = distance + linkedNode.distacne;
					pq.offer(new Node(linkedNode.index, result[linkedNode.index]));
				}
			}
		}
	}
}