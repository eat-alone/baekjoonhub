class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        int len = numbers.length;
        for(int i = 0; i<len; i++){
            answer = answer + numbers[i];
        }
        answer = answer / len;
        return answer;
    }
}