class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        int a = code;
        while(true){
            System.out.println(a);
            if(a > cipher.length()){
                System.out.println(a);
                break;
            }
            answer = answer + cipher.charAt(a-1);
            a = a + code;
        }
        return answer;
    }
}