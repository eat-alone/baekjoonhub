class Solution {
    public String solution(String rsp) {
        String answer = "";
        for(int i = 0; i < rsp.length(); i++){
            if((int)rsp.charAt(i) - '0' == 0){
                answer = answer + "5";
            }else if((int)rsp.charAt(i) - '0' == 2){
                answer = answer + "0";
            }else if((int)rsp.charAt(i) - '0' == 5){
                answer = answer + "2";
            }
        }
        return answer;
    }
}