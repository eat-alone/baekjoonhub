import java.util.Arrays;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] answer1 = my_string.toLowerCase().toCharArray();
        Arrays.sort(answer1);
        answer = new String(answer1);
        return answer;
    }
}