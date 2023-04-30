class Solution {
    public int solution(int[] array) {
        int answer = 0;
        if(array.length == 1){
            answer = array[0];
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
            }
        }
        answer = array[array.length / 2];
    }
        for(int k = 0; k < array.length; k++){
            System.out.print(array[k]);
        }
        return answer;
    }
    public static void swap(int[] arr, int idx1, int idx2) {
	    int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}