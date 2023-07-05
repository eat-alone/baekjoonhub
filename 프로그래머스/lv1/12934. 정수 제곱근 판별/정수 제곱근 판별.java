class Solution {
    public long solution(long n) {
        long answer = -1;
        long i = 1;
        
        while(true){
            if(i * i == n){
                answer = (i + 1) * (i + 1);
                break;
            }else if(i * i > n){
                break;
            }else{
                i = i + 1;    
            }
        }
        return answer;
    }
}