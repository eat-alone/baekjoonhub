class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int an = 0;
        String an1 = String.valueOf(x);
        for(int i = 0; i < an1.length(); i++){
            an = an + an1.charAt(i) - '0';
        }
        if(x % an == 0){
            answer = true;
        }else{
            answer = false;
        }
        return answer;
    }
}