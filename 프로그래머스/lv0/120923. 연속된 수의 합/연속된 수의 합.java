class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int temp = 1;
        int an = 0;
        while(true){
            if(an <= total){
                for(int i = 0; i < num; i++){
                    an = an + temp + i;
                }
                if(an == total){
                    for(int j = 0; j < num; j++){
                        answer[j] = temp + j;
                    }
                    return answer;
                }else if( an > total){
                    an = 0;
                    break;
                }else{
                    an = 0;
                    temp++;
                }
            }else{
                break;
            }
        }
        while(true){
            System.out.println("<<<<<");
            if(an <= total){
                for(int i = 0; i < num; i++){
                    an = an + temp + i;
                }
                if(an == total){
                    for(int j = 0; j < num; j++){
                        answer[j] = temp + j;
                    }
                    return answer;
                }else{
                    an = 0;
                    temp--;
                }
            }else{
                break;
            }
        }
        return answer;
    }
}