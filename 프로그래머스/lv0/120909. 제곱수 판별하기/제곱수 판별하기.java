class Solution {
    public int solution(int n) {
        int answer = 2;
        int a = 1;
        while(a * a <= n){
            System.out.println(a);
            if(a * a == n){
                answer = 1;
                return answer;
            }else{
                a++;
            }
        }
        return answer;
    }
}