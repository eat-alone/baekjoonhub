class Solution {
    public int solution(String str1, String str2) {
        int answer = 2;
        int n1 = str2.length(); // = 4
        int ri = 0;
        if(str1.length() < n1){
            answer = 2;
            return answer;
        }
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) == str2.charAt(0)){
                for(int j = 0; j < n1; j++){
                    if(i+j >= str1.length()){
                        answer = 2;
                        return answer;
                    }
                    if(str1.charAt(i+j) == str2.charAt(j)){
                        ri++;
                        if(ri == n1){
                            answer = 1;
                            return answer;
                        }
                    }else{
                        ri = 0;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}