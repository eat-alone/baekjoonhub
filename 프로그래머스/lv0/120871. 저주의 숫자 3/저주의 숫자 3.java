class Solution {
    public int solution(int n) {
        int answer = 0;
        int k = 0;
        int i = 0;
        String temp;
        int[] ans1 = new int[100];
        while(true){
            temp = Integer.toString(i);
            if(k == 100){
                break;
            }
            if(i % 3 == 0){
                i++;
            }else if(temp.indexOf("3") != -1){
                i++;
            }else{
                ans1[k] = i;
                k++;
                i++;
            }
        }
        for(int j = 0; j < 100; j++){
            System.out.print(ans1[j] + " ");
        }
        answer = ans1[n-1];
        return answer;
    }
}