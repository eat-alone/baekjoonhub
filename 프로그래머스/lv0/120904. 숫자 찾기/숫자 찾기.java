class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        String num1 =  String.valueOf(num); 
        for(int i = 0; i < num1.length(); i++){
            if(num1.charAt(i) - '0' == k){
                return i + 1;
            }
        }
        System.out.print(num1);
        return answer;
    }
}