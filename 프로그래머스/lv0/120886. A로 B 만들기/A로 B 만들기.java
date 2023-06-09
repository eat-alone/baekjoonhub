class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        char[] an1 = before.toCharArray();
        char[] an2 = after.toCharArray();
        for(int i = 0; i < before.length(); i++){
            for(int j = 0; j < after.length(); j++){
                if(an1[i] == an2[j]){
                    an2[j] = '.';
                    break;
                }
            }
        }
        for(int k = 0; k < after.length(); k++){
            if(an2[k] != '.'){
                return answer;
            }
        }
        answer = 1;
        return answer;
    }
}