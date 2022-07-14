import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }
}

public class Main {
    static int n;
    static Deque<Point> deque;
    static ArrayList<Point> apples;
    static HashMap<Integer, Character> dirs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 보드의 크기
        n = sc.nextInt();

        // 뱀을 표현할 덱
        deque = new LinkedList<>();
        deque.add(new Point(1, 1));

        // 사과의 개수
        int k = sc.nextInt();
        apples = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            apples.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        // 방향 변환 정보
        int l = sc.nextInt();
        dirs = new HashMap<>();
        for(int i = 0; i < l; i++){
            dirs.put(sc.nextInt(), sc.next().charAt(0));
        }

        int dir = 2; // 처음에는 오른쪽으로 직진하기 때문에 방향 정보 2를 준다
        int cnt = 0;
        while(true){
            cnt++;

            if(!move(dir))
                break;

            dir = changeDir(dir, cnt);
        }

        System.out.println(cnt);
    }

    static boolean move( int dir){
        Point cur = deque.peekFirst();
        int nx = cur.x;
        int ny = cur.y;
        switch (dir){
            // 위로 이동
            case 1:
                nx -= 1;
                break;
            // 오른쪽 이동
            case 2:
                ny += 1;
                break;
            // 아래로 이동
            case 3:
                nx += 1;
                break;
            // 왼쪽 이동
            case 4:
                ny -= 1;
                break;
        }

        Point next = new Point(nx, ny);
        // 탈출 조건 (자기 몸에 부딪히거나, 벽에 부딪힌 경우)
        if(nx <= 0 || nx > n || ny <= 0 || ny > n || deque.contains(next))
            return false;

        // 사과가 있는지 검사
        if(apples.contains(next)){ // 사과가 있으면, 그 칸에 사과는 없어지고 꼬리는 없어지지 않는다
            deque.offerFirst(next);
            apples.remove(next);
        }
        else{   // 사과가 없으면 이동
            deque.offerFirst(next);
            deque.removeLast();
        }

        return true;
    }

    // 시계 순으로 상(1) 우(2) 하(3) 좌(4)
    static int changeDir(int dir, int cnt){
        if(dirs.containsKey(cnt)){
            // 왼쪽 회전
            if(dirs.get(cnt) == 'L'){
                dir--;
                if(dir == 0)
                    dir = 4;
            }
            // 오른쪽 회전
            else{
                dir++;
                if(dir == 5)
                    dir = 1;
            }
        }

        return dir;
    }
}
