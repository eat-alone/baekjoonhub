class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int ptemp = 0;
        int ytemp = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P'){
                ptemp++;
            }else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
                ytemp++;
            }
        }
        if(ptemp == ytemp){
            answer = true;
        }else{
            answer = false;
        }
        return answer;
    }
}