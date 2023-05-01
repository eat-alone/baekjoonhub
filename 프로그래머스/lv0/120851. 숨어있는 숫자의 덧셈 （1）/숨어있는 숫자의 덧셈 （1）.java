class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(int i = 0; i < my_string.length(); i++){
            if(47 < (int)my_string.charAt(i) && (int)my_string.charAt(i) < 58){
                answer = answer + (int)my_string.charAt(i) - '0';
            }
        }
        return answer;
    }
}