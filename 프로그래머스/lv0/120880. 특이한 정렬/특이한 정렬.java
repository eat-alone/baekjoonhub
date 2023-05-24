class Solution {
    public static void swap(int[] arr, int idx1, int idx2) {
	int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
    }
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        for(int i = 0; i < numlist.length - 1; i++){
            for(int j = 0; j < numlist.length - 1 - i; j++){
                if(Math.abs(numlist[j] - n) > Math.abs(numlist[j+1] - n)){
                    swap(numlist, j, j + 1);
                }else if(Math.abs(numlist[j] - n) == Math.abs(numlist[j+1] - n)){
                    if(numlist[j] - n > numlist[j+1] - n){
                        numlist[j] = numlist[j];
                    }else{
                        swap(numlist, j, j + 1);
                    }
                }
            }
        }
        answer = numlist;
        return answer;
    }
}