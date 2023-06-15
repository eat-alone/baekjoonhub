class Solution {
    public int solution(int[] array) {
        int answer = 0;
        char[] an1 = {};
        String an2 = "";
        for(int i = 0; i < array.length; i++){
            an2 = Integer.toString(array[i]);
            an1 = new char[an2.length()];
            an1 = an2.toCharArray();
            for(int j = 0; j < an1.length; j++){
                if(an1[j] == '7'){
                    answer++;
                }
            }
        }
        return answer;
    }
}