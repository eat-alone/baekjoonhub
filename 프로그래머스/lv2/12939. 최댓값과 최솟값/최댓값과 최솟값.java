import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] an1 = s.split(" ");
        int[] an2 = new int[an1.length];
        for(int i = 0; i < an2.length; i++){
            an2[i] = Integer.valueOf(an1[i]);
        }
        Arrays.sort(an2);
        answer = an2[0] + " " + an2[an2.length - 1];
        return answer;
    }
}