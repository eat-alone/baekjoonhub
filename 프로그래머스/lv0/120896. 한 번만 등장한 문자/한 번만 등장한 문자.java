import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] an1 = s.toCharArray();
        int temp = 0;
        for(int i = 0; i < an1.length; i++){
            for(int j = 0; j < an1.length; j++){
                if(i == j){
                    answer = answer;
                }else if(an1[i] == an1[j]){
                    an1[j] = '.';
                    temp = 1;
                }
            }
            if(temp == 1){
                an1[i] = '.';
                temp = 0;
            }
        }
        Arrays.sort(an1);
        for(int k = 0; k < an1.length; k++){
            if(an1[k] != '.'){
                answer = answer + Character.toString(an1[k]);
            }
        }
        return answer;
    }
}