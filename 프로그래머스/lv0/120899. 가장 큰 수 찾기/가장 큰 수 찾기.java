class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int temp = array[0];
        int temp2 = 0;
        for(int i = 1; i < array.length; i++){
            if(temp < array[i]){
                temp = array[i];
            }
        }
        answer[0] = temp;
        temp = array[0];
        for(int i = 1; i < array.length; i++){
            if(temp < array[i]){
                temp = array[i];
                temp2 = i;
            }
        }
        answer[1] = temp2;
        return answer;
    }
}