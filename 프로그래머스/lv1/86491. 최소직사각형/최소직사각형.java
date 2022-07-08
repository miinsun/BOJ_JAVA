class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int bigSize = 0;
        int smallSize = 0;
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] >= sizes[i][1]){
                bigSize = Math.max(sizes[i][0], bigSize);
                smallSize = Math.max(sizes[i][1], smallSize);
            }
            else{
                bigSize = Math.max(sizes[i][1], bigSize);
                smallSize = Math.max(sizes[i][0], smallSize);
            }
        }
        
        answer = bigSize * smallSize;
        return answer;
    }
}