class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        char temp;
        char[] answer1 = new char[my_string.length()];
        for(int i = 0; i < my_string.length(); i++){
            answer1[i] = my_string.charAt(i);
        }
        temp = answer1[num1];
        answer1[num1] = answer1[num2];
        answer1[num2] = temp;
        answer = new String(answer1);
        for(int j = 0; j < my_string.length(); j++){
            System.out.print(answer1[j]);
        }
        return answer;
    }
}