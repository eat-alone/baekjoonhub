class Solution {
    public int solution(int[] common) {//4
        int answer = 0;
        int temp1 = 0;
        int a1 = 0;
        int[] temp = new int[common.length - 1];//3
        for(int i = 0; i < common.length - 1; i++){//i = 0~2
            temp[i] = common[i+1]-common[i];// 0 2 1 / 1 3 2 / 2 4 3
        }
        temp1 = temp[0];
        for(int i = 0; i < temp.length; i++){
            if(temp1 == temp[i]){
                a1++;
            }
        }
        if(a1 == temp.length){
            answer = common[common.length - 1] + temp1;
        }else{
            answer = common[common.length - 1] * (common[1] / common[0]);
        }
        return answer;
    }
}