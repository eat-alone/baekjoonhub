class Solution {
    public int[] solution(int n, int[] numlist) {
        int n1 = 0;
        for(int i = 0; i < numlist.length; i++){
            if(numlist[i] % n == 0){
                n1++;
            }
        }
        int[] answer = new int[n1];
        int n2 = 0;
        for(int j = 0; j < numlist.length; j++){
            if(numlist[j] % n == 0){
                answer[n2] = numlist[j];
                n2++;
            }
        }
        return answer;
    }
}