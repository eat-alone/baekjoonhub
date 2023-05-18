class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        String[] A1 = new String[A.length()];
        String[] B1 = new String[B.length()];
        String temp = " ";
        int j = 0;
        int k = 0;
        for(int i = 0; i < A.length(); i++){
            A1[i] = Character.toString(A.charAt(i));
            B1[i] = Character.toString(B.charAt(i));
        }
        for(int i = 0; i < A1.length; i++){
                if(A1[i].equals(B1[i])){
                    j++;
                }
        }
        if(j == A1.length){
                answer = 0;
                return answer;
        }else{
            j = 0;
        }
        if(A1.length == 1){
            if(A1[0] == B1[0]){
                answer = 0;
                return answer;
            }else{
                answer = -1;
                return answer;
            }
        }
        while(true){
            if(k == A1.length * 2){
                answer = -1;
                return answer;
            }
            for(int i = 0; i < A1.length; i++){
                if(A1[i].equals(B1[i])){
                    j++;
                    System.out.println(j);
                }
            }
            if(j == A1.length){
                answer = k;
                return answer;
            }else{
                j = 0;
                k++;
                for(int i = A1.length - 1; i > 0; i--){
                    temp = A1[i];
                    A1[i] = A1[i-1];
                    A1[i-1] = temp;
                }    
            }
        }
    }
}