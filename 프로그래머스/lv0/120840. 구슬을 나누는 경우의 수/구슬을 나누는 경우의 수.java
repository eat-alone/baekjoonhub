class Solution {
    public double solution(double balls, double share) {
        double answer = 0;
        if(balls == share){
            return 1;
        }
        answer = Math.round(pac(balls) / (pac(balls - share) * pac(share)));
        return answer;
    }
    public double pac(double n){
        double ans = 1;
        while(n != 1){
            ans = ans * n;
            n--;
        }
        return ans;
    }
}