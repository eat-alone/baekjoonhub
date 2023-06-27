class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        String an1 = String.valueOf(n);
        answer = new int[an1.length()];
        int temp = an1.length() - 1;
        for(int i = 0; i < an1.length(); i++){
            answer[i] = an1.charAt(temp) - '0';
            temp--;
        }
        return answer;
    }
}