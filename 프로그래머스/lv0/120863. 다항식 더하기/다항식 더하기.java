class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int temp = 0;
        int temp2 = 0;
        for(int i = 0 ; i < polynomial.length(); i++){
            if(polynomial.length() == 1){
                answer = polynomial;
                return answer;
            }
            if(polynomial.charAt(i) == ' '){
                if(polynomial.charAt(i-1) == 'x'){
                    if(i-2 < 0){
                        temp2++;
                    }else if(i - 3 >= 0 && polynomial.charAt(i-3) != ' ' && polynomial.charAt(i-3) != '+'){
                        temp2 = temp2 + (polynomial.charAt(i-3) - '0') * 10 + (polynomial.charAt(i-2) - '0');
                    }else if(polynomial.charAt(i-2) == ' '){
                        temp2++;
                    }else{
                        temp2 = temp2 + polynomial.charAt(i-2) - '0';
                    }
                }else if(polynomial.charAt(i-1) != '+'){
                    if(i - 2 >= 0 && polynomial.charAt(i-2) != ' '){
                        temp = temp + (polynomial.charAt(i-2) - '0') * 10 + (polynomial.charAt(i-1) - '0');
                    }else{
                        temp = temp + polynomial.charAt(i-1) - '0';
                    }
                }
            }
        }
        if(polynomial.length() != 1 && polynomial.charAt(polynomial.length() - 1) == 'x'){
            if(polynomial.charAt(polynomial.length() - 2) == ' '){
                temp2++;
            }else if(polynomial.length() - 3 >= 0 && polynomial.charAt(polynomial.length()-3) != ' ' && polynomial.charAt(polynomial.length()-3) != '+'){
                temp2 = temp2 + (polynomial.charAt(polynomial.length()-3) - '0') * 10 + (polynomial.charAt(polynomial.length()-2) - '0') ;
            }else{
                temp2 = temp2 + polynomial.charAt(polynomial.length() - 2) - '0';
            }
        }else if(polynomial.length() != 1 && polynomial.charAt(polynomial.length() - 1) != '+'){
            if(polynomial.length() - 2 >= 0 && polynomial.charAt(polynomial.length()-2) != ' '){
                temp = temp + (polynomial.charAt(polynomial.length() - 2) - '0') * 10 + polynomial.charAt(polynomial.length() - 1) - '0';
            }else{
                temp = temp + polynomial.charAt(polynomial.length() - 1) - '0';
            }
        }
        if(temp == 0){
            answer = temp2+"x";
        }else if(temp2 == 0){
            answer = temp+"";
        }else if(temp2 == 1){
            answer = "x" + " + " + temp;
        }else{
            answer = temp2+"x "+"+ "+temp;    
        }
        return answer;
    }
}