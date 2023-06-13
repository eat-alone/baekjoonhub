class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int i = 1;
        /*
        if(numbers.length == 3){
            if(k % 3  == 0){
                answer = 2;
                return answer;
            }else if(k % 3 == 2){
                answer = 3;
                return answer;
            }else{
                answer = 1;
                return answer;
            }
        }*/
        while(k != 1){
            if(i + 1 > numbers.length){
                i = 2;
            }else if(i + 2 > numbers.length){
                i = 1;
            }else{
                i = i + 2;
            }
            System.out.println("k:번째실행 : " + k + "  i의 값 : " + i);
            k--;
        }
        answer = numbers[i-1];
        return answer;
    }
}