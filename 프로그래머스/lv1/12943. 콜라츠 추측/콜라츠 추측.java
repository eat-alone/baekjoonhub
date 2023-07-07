class Solution {
    public int solution(double num) {
        int answer = 0;
        if(num == 1){
            return answer;
        }
        while(true){
            if(answer == 500){
                answer = -1;
                break;
            }else if(num == 1){
                break;
            }else if(num % 2 == 0){
                num = num / 2;
                answer++;
            }else if(num % 2 == 1){
                num = num * 3 + 1;
                answer++;
            }
        }
        return answer;
    }
}