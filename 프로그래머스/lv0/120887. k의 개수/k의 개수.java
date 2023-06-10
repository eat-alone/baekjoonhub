class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String an1 = "";
        String an2 =  Integer.toString(k);
        char[] an3 = {};
        for(int z = i; z <= j; z++){
            an1 =  Integer.toString(z);
            an3 = an1.toCharArray();
            for(int h = 0; h < an3.length; h++){
                if(an3[h]-'0' == k){
                    answer++;
                }
            }
        }
        return answer;
    }
}