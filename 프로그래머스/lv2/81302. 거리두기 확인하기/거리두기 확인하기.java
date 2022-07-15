import java.util.*;

class Point{
    int x;
    int y;
    int dist;
    
    Point(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class Solution {
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    
    public int bfs(int x, int y, String[] place){
        boolean[][] visited = new boolean[5][5];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));  // 응시자 위치를 시작점으로 지정
                    
        while(!q.isEmpty()){
            Point cur = q.poll();
            visited[x][y] = true;
            for(int k = 0; k < 4; k++){
                int ny = cur.y + dy[k];
                int nx = cur.x + dx[k];

                // 응시자의 다음 거리가 2보다 클 경우 정지 
                if(cur.dist + 1 > 2)
                    break;

                // 대기실의 범위 검사와 중복 검사
                if(nx < 5 && ny < 5 && nx >= 0 && ny >= 0 && !visited[nx][ny]){
                    // 파티션일 있는 경우 거리를 재지 않는다
                    if(place[nx].charAt(ny) == 'X')
                        continue;
                    // 거리두기가 이뤄지지 않으면 '0'리턴
                    else if(place[nx].charAt(ny) == 'P')
                        return 0;
                    // 빈 테이블의 경우 거리를 재준다
                    else
                        q.add(new Point(nx, ny, cur.dist + 1));
                }
            }
        }
        
        return 1;
    }
    
    public int isKeepDistance(String[] place){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                // 응시자를 중심으로 bfs 시작
                if(place[i].charAt(j) == 'P'){ 
                    // 거리두기를 지키지 않고 있으면 0 리턴
                    if(bfs(i, j, place) == 0){
                        return 0;
                    }
                }                
            }
        }

        // 모두 거리두기를 하고 있으면 1 리턴
        return 1;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++){
            answer[i] = isKeepDistance(places[i]);
        }
        
        return answer;
    }
}