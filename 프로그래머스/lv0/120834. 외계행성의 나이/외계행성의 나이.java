class Solution {
    public String solution(int age) {
        String answer = "";
        String answer2 = String.valueOf(age);
        for(int i = 0; i< answer2.length(); i++){
            if(answer2.charAt(i) == '0'){
                answer = answer + "a";
            }else if(answer2.charAt(i) == '1'){
                answer = answer + "b";
            }else if(answer2.charAt(i) == '2'){
                answer = answer + "c";
            }else if(answer2.charAt(i) == '3'){
                answer = answer + "d";
            }else if(answer2.charAt(i) == '4'){
                answer = answer + "e";
            }else if(answer2.charAt(i) == '5'){
                answer = answer + "f";
            }else if(answer2.charAt(i) == '6'){
                answer = answer + "g";
            }else if(answer2.charAt(i) == '7'){
                answer = answer + "h";
            }else if(answer2.charAt(i) == '8'){
                answer = answer + "i";
            }else if(answer2.charAt(i) == '9'){
                answer = answer + "j";
            }
        }
        return answer;
    }
}