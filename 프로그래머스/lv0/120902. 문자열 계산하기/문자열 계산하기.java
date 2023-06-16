class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] answer1 = {};
        String temp1 = "";
        int temp = 1;
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) == ' '){
                temp++;
            }
        }
        answer1 = new String[temp];
        temp = 0;
        for(int i = 0; i < answer1.length; i++){
            for(int j = temp; j < my_string.length(); j++){
                if(my_string.charAt(j) == ' '){
                    for(int k = temp; k < j; k++){
                        temp1 += Character.toString(my_string.charAt(k));
                        temp = j+1;
                    }
                    answer1[i] = temp1;
                    temp1 = "";
                    break;
                }
            }
        }
        for(int i = temp; i < my_string.length(); i++){
            temp1 += Character.toString(my_string.charAt(i));
        }
        answer1[answer1.length - 1] = temp1;
        answer = Integer.valueOf(answer1[0]);
        for(int i = 0; i < answer1.length; i++){
            System.out.println(answer1[i]);
            if(answer1[i].equals("+")){
                answer = answer + Integer.valueOf(answer1[i+1]);
            }else if(answer1[i].equals("-")){
                answer = answer - Integer.valueOf(answer1[i+1]);
            }
        }
        return answer;
    }
}