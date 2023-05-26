class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] ans1 = new double[score.length];
        for(int k = 0; k < score.length; k++){
            if(score[k][0] + score[k][1] == 0){
                ans1[k] = 0;
            }else{
                ans1[k] = (score[k][0] + score[k][1]) / 2.0;    
            }
            answer[k] = 1;
            System.out.print(ans1[k] + " ");
        }
        
        for(int i = 0; i < score.length; i++){
            for(int j = 0; j < score.length; j++){
                if(ans1[i] < ans1[j]){
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}