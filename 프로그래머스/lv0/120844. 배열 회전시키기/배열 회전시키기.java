class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        if(direction.charAt(0) == 'r'){
            answer[0] = numbers[numbers.length - 1];
            for(int i = 0; i < numbers.length; i++){
                if(i + 1 == numbers.length){
                    break;
                }
                answer[i + 1] = numbers[i];
            }
        }else{
            answer[numbers.length - 1] = numbers[0];
            for(int i = 0; i < numbers.length; i++){
                if(i + 1 == numbers.length){
                    break;
                }
                answer[i] = numbers[i + 1];
            }
        }
        return answer;
    }
}