class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int an1 = 0;
        int an2 = 0;
        int temp = 0;
        if(sides[0] > sides[1]){
            temp = sides[0] - sides[1];
            an1 = sides[0] - temp;
            an2 = sides[1] - 1;
            if(an1 == 1 && an2 == 1){
                answer = 1;
            }else{
                answer = an1 + an2;
            }
        }else if(sides[1] > sides[0]){
            temp = sides[1] - sides[0];
            an1 = sides[1] - temp;
            an2 = sides[0] - 1;
            if(an1 == 1 && an2 == 1){
                answer = 1;
            }else{
                answer = an1 + an2;
            }
        }else{
            answer = sides[0] + sides[1] - 1;
        }
        return answer;
    }
}