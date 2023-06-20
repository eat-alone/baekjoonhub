import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String an1 = n+"";
        for(int i = 0; i < an1.length(); i++){
            answer = answer + an1.charAt(i) - '0';
        }
        return answer;
    }
}