class Solution {
    public int solution(int[][] triangle) {
        int max = 0;

        if(triangle.length == 1){
            return triangle[0][0];
        }

        if(triangle.length == 2){
            if(triangle[0][0] + triangle[1][0] > triangle[0][0] + triangle[1][1]){
                return triangle[0][0] + triangle[1][0];
            }else{
                return triangle[0][0] + triangle[1][1];
            }
        }

        triangle[1][0] = triangle[0][0] + triangle[1][0];
        triangle[1][1] = triangle[0][0] + triangle[1][1];

        for(int i = 2; i < triangle.length; i++){
            for(int j = 0; j < i+1; j++){
                if(j == 0){
                    triangle[i][j] = triangle[i - 1][0] + triangle[i][j];
                }else if(j == i){
                    triangle[i][i] = triangle[i][i] + triangle[i - 1][i - 1];
                }else{
                    if(triangle[i][j] + triangle[i-1][j-1] > triangle[i][j] + triangle[i-1][j]){
                        triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
                    }else{
                        triangle[i][j] = triangle[i][j] + triangle[i-1][j];
                    }
                }
            }
            if(i == triangle.length - 1){
                for(int j = 0; j < i + 1; j++){
                    if(triangle[i][j] > max){
                        max = triangle[i][j];
                    }
                }
            }
        }
        return max;
    }
}