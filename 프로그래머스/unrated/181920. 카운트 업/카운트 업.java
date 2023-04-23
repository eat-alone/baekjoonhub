class Solution {
    public int[] solution(int start, int end) {
        int[] answer = new int[end - start + 1];
        int n1 = 0;
        for(int i = start; i < end + 1; i++){
            answer[n1] = i;
            n1++;
        }
        return answer;
    }
}