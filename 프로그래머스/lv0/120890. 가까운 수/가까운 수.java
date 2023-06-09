import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        int answer = array[0];
        int[] ans = new int[array.length];
        int temp = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] - n < 0){
                ans[i] = n - array[i];
            }else{
                ans[i] = array[i] - n;
            }
        }
        temp = ans[0];
        for(int j = 0; j < ans.length; j++){
            System.out.print(ans[j] + "  ");
            if(ans[j] < temp){
                System.out.println(temp);
                temp = ans[j];
                answer = array[j];
            }
        }
        return answer;
    }
}