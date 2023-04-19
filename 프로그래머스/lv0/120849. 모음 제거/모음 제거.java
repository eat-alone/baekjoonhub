class Solution {
    public String solution(String my_string) {
        String answer = "";
        char c1;
        char a1 = 'a';
        char e1 = 'e';
        char i1 = 'i';
        char o1 = 'o';
        char u1 = 'u';
        for(int i = 0; i < my_string.length(); i++){
            c1 = my_string.charAt(i);
            if(c1 == a1){
                answer = answer + "";
            }else if(c1 == e1){
                answer = answer + "";
            }else if(c1 == i1){
                answer = answer + "";
            }else if(c1 == o1){
                answer = answer + "";
            }else if(c1 == u1){
                answer = answer + "";
            }else{
                answer = answer + my_string.charAt(i);
            }
        }
        return answer;
    }
}