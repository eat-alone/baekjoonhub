class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] answer1 = {};
        String temp1 = "";
        int temp = 1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                temp++;
            }
        }
        answer1 = new String[temp];
        temp = 0;
        for(int i = 0; i < answer1.length; i++){
            for(int j = temp; j < s.length(); j++){
                if(s.charAt(j) == ' '){
                    for(int k = temp; k < j; k++){
                        temp1 += Character.toString(s.charAt(k));
                        temp = j+1;
                    }
                    answer1[i] = temp1;
                    temp1 = "";
                    break;
                }
            }
        }
        for(int i = temp; i < s.length(); i++){
            temp1 += Character.toString(s.charAt(i));
        }
        answer1[answer1.length - 1] = temp1;
        for(int i = 0; i < answer1.length; i++){
            System.out.println(answer1[i]);
            if(answer1[i].equals("Z")){
                answer = answer - Integer.valueOf(answer1[i - 1]);
            }else{
                answer = answer + Integer.valueOf(answer1[i]);
            }
        }
        return answer;
    }
}