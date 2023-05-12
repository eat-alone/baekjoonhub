class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int pri = 0;
        int sec = 0;
        int ter = 0;
        int qua = 0;
        for(int i = lines[0][0]; i < lines[0][1]; i++){
            for(int j = lines[1][0]; j < lines[1][1]; j++){
                if(i == j){
                    pri++;
                }
            }
        }
        for(int i = lines[0][0]; i < lines[0][1]; i++){
            for(int j = lines[2][0]; j < lines[2][1]; j++){
                if(i == j){
                    sec++;
                }
            }
        }
        for(int i = lines[1][0]; i < lines[1][1]; i++){
            for(int j = lines[2][0]; j < lines[2][1]; j++){
                if(i == j){
                    ter++;
                }
            }
        }
        for(int i = lines[0][0]; i < lines[0][1]; i++){
            for(int j = lines[1][0]; j < lines[1][1]; j++){
                for(int k = lines[2][0]; k < lines[2][1]; k++){
                    if(i == k && i == j && j == k){
                        qua++;
                    }
                }
            }
        }
        answer = pri + sec + ter - (qua * 2);
        return answer;
    }
}