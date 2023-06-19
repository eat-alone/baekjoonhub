class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int xray = 0;
        int yray = 0;
        for(int i = 0; i < 4; i++){
            for(int j = i + 1; j < 4; j++){
                if(dots[i][0] == dots[j][0]){
                    if(dots[i][1] > dots[j][1]){
                        yray = dots[i][1] - dots[j][1];
                    }else{
                        yray = dots[j][1] - dots[i][1];
                    }
                }
                if(dots[i][1] == dots[j][1]){
                    if(dots[i][0] > dots[j][0]){
                        xray = dots[i][0] - dots[j][0];
                    }else{
                        xray = dots[j][0] - dots[i][0];
                    }
                }
            }
        }
        answer = xray * yray;
        return answer;
    }
}