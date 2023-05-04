class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        int a1 = box[0] / n;
        int a2 = box[1] / n;
        int a3 = box[2] / n;
        answer = a1 * a2 * a3;
        return answer;
    }
}