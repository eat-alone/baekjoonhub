class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        String temp = "0";
        for(int i = 0; i < strlist.length; i++){
            temp = strlist[i];
            answer[i] = temp.length();
        }
        return answer;
    }
}