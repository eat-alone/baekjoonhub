class Solution {
    public int solution(int order) {
        int answer = 0;
        String answer1 = String.valueOf(order);
        for(int i = 0; i < answer1.length(); i++){
            System.out.println(String.valueOf(order).charAt(i));
            if(answer1.charAt(i) == '0'){
                answer = answer;
            }else if(answer1.charAt(i) % 3 == 0){
                answer++;
            }
        }
        return answer;
    }
}