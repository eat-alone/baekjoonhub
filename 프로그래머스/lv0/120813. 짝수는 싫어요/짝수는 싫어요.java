import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            if(i % 2 == 1){
                answer.add(i);
            }
        }
        return answer;
    }
}