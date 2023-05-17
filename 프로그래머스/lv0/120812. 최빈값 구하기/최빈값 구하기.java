class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int temp = 0;
        int[] answer2 = new int[1000];
        for(int i = 0; i < array.length; i++){
            answer2[array[i]]++;
        }
        temp = answer2[0];
        for(int i = 1; i < 1000; i++){
            if(answer2[i] > temp){
                temp = answer2[i];
                answer = i;
            }else if(answer2[i] == temp){
                answer = -1;
            }
        }
        return answer;
    }
}