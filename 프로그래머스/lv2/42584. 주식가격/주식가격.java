class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                int cnt = 0;
                if(prices[i] <= prices[j]){
                    answer[i]++;
                }
                else{
                    answer[i]++;
                    break;    
                }
            }
        }
        return answer;
    }
}