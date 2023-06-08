import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] an1 = my_string.toCharArray();
        for(int i = 0; i < an1.length; i++){
            for(int j = i + 1; j < an1.length; j++){
                if(an1[i] == an1[j]){
                    System.out.println(an1[i] + "  " + an1[j]);
                    an1[j] = '.';
                }
            }
        }
        for(int k = 0; k < an1.length; k++){
            if(an1[k] == '.'){
                answer = answer;
            }else{
                System.out.print("1");
                answer = answer + an1[k];
            }
        }
        return answer;
    }
}