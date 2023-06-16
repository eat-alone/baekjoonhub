class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};
        String ans = "";
        int temp = 0;
        
        if(my_str.length() % n != 0){
            answer = new String[my_str.length() / n + 1];
        }else{
            answer = new String[my_str.length() / n];
        }
        
        for(int i = 0; i < answer.length; i++){
            for(int j = temp; j < my_str.length(); j++){
                if(j % n == n - 1){
                    for(int k = temp; k <= j; k++){
                        ans += Character.toString(my_str.charAt(k));
                        temp = j+1;
                    }
                    answer[i] = ans;
                    ans = "";
                    break;
                }
            }
        }
        
        if(my_str.length() % n != 0){
            for(int i = temp; i < my_str.length(); i++){
                ans += Character.toString(my_str.charAt(i));
            }
            answer[answer.length - 1] = ans;
        }
        
        return answer;
    }
}