import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        int temp = 0;
        while(true){
            for(int i = 2; i <= n; i++){//n = 12
                if(n % i == 0){//i = 2;
                    if(answer.size() == 0){//add(2); n = 6;
                        n = n / i;
                        answer.add(i);
                        break;
                    }
                    for(int j = 0; j < answer.size(); j++){
                        if(answer.get(j) == i){
                            temp = 1;
                        }
                    }
                    if(temp == 0){
                        n = n / i;
                        answer.add(i);
                        break;
                    }else{
                        n = n / i;
                        temp = 0;
                        break;
                    }
                }
            }
            if(n == 1){
                break;
            }
        }
        return answer;
    }
}