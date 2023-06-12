class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) < 58 && my_string.charAt(i) > 47){
                System.out.print((int)my_string.charAt(i) - '0' + "   ");
                if(i+1 >= my_string.length()){
                    answer = answer + my_string.charAt(i) - '0';
                }else if(my_string.charAt(i+1) < 58 && my_string.charAt(i+1) > 47){
                    if(i+2 >= my_string.length()){
                        answer = answer + (my_string.charAt(i) - '0') * 10 + my_string.charAt(i+1) - '0';
                        i = i + 1;
                    }else if(my_string.charAt(i+2) < 58 && my_string.charAt(i+2) > 47){
                        if(i+3 >= my_string.length()){
                            answer = answer + (my_string.charAt(i) - '0') * 100 + (my_string.charAt(i+1) - '0') * 10 + (my_string.charAt(i+2) - '0');
                            i = i + 2;
                        }else if(my_string.charAt(i+3) < 58 && my_string.charAt(i+2) > 47){
                            answer = answer + (my_string.charAt(i) - '0') * 1000 + (my_string.charAt(i+1) - '0') * 100 + (my_string.charAt(i+2) - '0') * 10 + (my_string.charAt(i+3) - '0');
                            i = i + 3;
                        }else{
                            answer = answer + (my_string.charAt(i) - '0') * 100 + (my_string.charAt(i+1) - '0') * 10 + (my_string.charAt(i+2) - '0');
                            i = i + 2;
                        }
                    }else{
                        answer = answer + (my_string.charAt(i) - '0') * 10 + my_string.charAt(i+1) - '0';
                        i = i + 1;
                    }
                }else{
                    answer = answer + my_string.charAt(i) - '0';
                }
            }else{
                answer = answer;
            }
        }
        return answer;
    }
}