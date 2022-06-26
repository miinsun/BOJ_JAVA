class Solution {
    public int solution(String s) {        
        char[] arr = s.toCharArray();
        String[] numList = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        String tmp = "";
        String answer = "";
        for(int i = 0; i < arr.length; i++){
            // 숫자일 경우
            if(Character.isDigit(arr[i])){
                answer += arr[i];
            }
            // 문자일 경우
            else{
                tmp += arr[i];

                // 만약 숫자 열이 만들어진 경우는 answer에 추가
                for(int j = 0; j < numList.length; j++){
                    if(tmp.equals(numList[j])){
                        answer += j;
                        tmp = "";
                    }
                }
            }     
        }
        
        return Integer.parseInt(answer);
    }
}