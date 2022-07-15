class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        
        // i초의 시점을 기준으로 진행
        for(int i = 0; i < prices.length; i++){
            // i초 이후로 검사를 진행
            for(int j = i + 1; j < prices.length; j++){
                answer[i]++;

                if(prices[i] > prices[j]){   // i초보다 작은 값이 있다면 반복문 중단
                    break;    
                }
            }
        }
        
        return answer;
    }
}