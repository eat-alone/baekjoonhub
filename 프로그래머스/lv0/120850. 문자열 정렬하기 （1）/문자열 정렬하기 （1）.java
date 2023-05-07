class Solution {
    public static void swap(int[] arr, int idx1, int idx2) {
	int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
}
    public int[] solution(String my_string) {
        int a1 = 0;
        for(int i = 0; i < my_string.length(); i++){
            if((int)my_string.charAt(i) >= 48 && (int)my_string.charAt(i) <= 57){
                a1++;
            }
        }
        int[] answer = new int[a1];
        a1 = 0;
        for(int j = 0; j < my_string.length(); j++){
            if((int)my_string.charAt(j) >= 48 && (int)my_string.charAt(j) <= 57){
                answer[a1] = (int)my_string.charAt(j) - '0';
                a1++;
            }
        }
        for(int k = 0; k < answer.length - 1; k++){
            for (int z = 0; z < answer.length - k - 1; z++) {
                if (answer[z] > answer[z + 1]) {
                    swap(answer, z, z + 1);
                }
            }
        }
        return answer;
    }
}