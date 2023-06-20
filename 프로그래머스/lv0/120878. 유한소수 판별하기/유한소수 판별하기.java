class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int[] an1 = {};
        int[] an2 = {};
        int[] an3 = {};
        int temp = 0;
        int temp2 = 0;
        for(int i = 2; i <= a; i++){
            if(a % i == 0){ // 2, 3, 4, 6, 12
                answer++;
            }
        }
        
        an1 = new int[answer];
        answer = 0;
        for(int i = 2; i <= a; i++){
            if(a % i == 0){
                an1[answer] = i;
                answer++;
            }
        }
        
        
        answer = 0;
        for(int i = 2; i <= b; i++){
            if(b % i == 0){
                answer++;
            }
        }
        
        an2 = new int[answer];
        answer = 0;
        for(int i = 2; i <= b; i++){
            if(b % i == 0){
                an2[answer] = i;
                answer++;
            }
        }
        
        for(int i = an1.length - 1; i >= 0; i--){
            for(int j = an2.length - 1; j >= 0; j--){
                if(an1[i] == an2[j]){
                    temp = an1[i];
                    break;
                }
            }
            if(temp != 0){
                break;
            }
        }
        
        if(temp == 0){
            b = b;
        }else{
            b = b / temp;
        }
        
        temp2 = b;
        temp = 0;
        
        
        while(true){
            if(temp2 == 1){
                break;
            }
            for(int i = 2; i <= temp2; i++){
                if(temp2 % i == 0){
                    temp2 = temp2 / i;
                    temp++;
                    break;
                }
            }
        }
        
        
        an3 = new int[temp];
        temp = 0;
        
        while(true){
            if(b == 1){ //20 2 7
                break;
            }
            for(int i = 2; i <= b; i++){
                if(b % i == 0){
                    an3[temp] = i;
                    b = b / i;
                    temp++;
                    break;
                }
            }
        }
        
        for(int i = 0 ; i < an3.length; i++){
            if(an3[i] == 2){
                answer = 1;
            }else if(an3[i] == 5){
                answer = 1;
            }else{
                answer = 2;
                return answer;
            }
        }
        answer = 1;
        return answer;
    }
}