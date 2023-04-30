class Solution {
    public int solution(int n) {
        int answer = 0;
        String n1 = Integer.toString(n);
        for(int i = 0; i < n1.length(); i++){
            answer = answer + (int)n1.charAt(i) - '0';
        }
        return answer;
    }
}