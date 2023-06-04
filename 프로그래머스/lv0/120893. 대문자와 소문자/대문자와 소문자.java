class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] answer1 = new char[my_string.length()];
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) > 64 && my_string.charAt(i) < 91){
                answer1[i] = (char)((int)my_string.charAt(i) + 32);
            }else{
                answer1[i] = (char)((int)my_string.charAt(i) - 32);
            }
        }
        answer = new String(answer1);
        return answer;
    }
}