class Solution {
    public int solution(int hp) {
        int answer = 0;
        int a1 = hp / 5;
        int a2 = (hp % 5) / 3;
        int a3 = (hp % 5) % 3;
        answer = a1 + a2 + a3;
        return answer;
    }
}