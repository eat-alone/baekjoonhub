class Solution {
    public int[] solution(int n) {
        int n1= 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                n1++;
            }
        }
        int[] answer = new int[n1];
        n1 = 0;
        for(int j = 1; j <= n; j++){
            if(n % j == 0){
                answer[n1] = j;
                n1++;
            }
        }
        return answer;
    }
}