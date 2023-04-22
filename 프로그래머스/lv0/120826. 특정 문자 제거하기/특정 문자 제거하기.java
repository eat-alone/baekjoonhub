class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        char temp;
        char temp2 = letter.charAt(0);
        for(int i = 0; i < my_string.length(); i++){
            temp = my_string.charAt(i);
            if(temp == temp2){
                answer = answer + "";
            }else{
                answer = answer + my_string.charAt(i);
            }
        }
        return answer;
    }
}