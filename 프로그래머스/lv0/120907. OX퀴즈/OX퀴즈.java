class Solution {
    public String[] solution(String[] quiz) {
        String[] a1 = new String[5];
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            int len = 0;
            int k = 0;
            for(int j = 0; j < quiz[i].length(); j++){
                if(j+1 >= quiz[i].length()){
                    a1[k] = quiz[i].substring(len,j+1);
                }
                if(quiz[i].charAt(j) == 32){
                    a1[k] = quiz[i].substring(len,j);
                    len = j+1;
                    k++;
                }
            }
            if(a1[1].equals("-")){
                System.out.println(a1[0] + "-" + a1[2] + "=" + a1[4]);
                if(Integer.parseInt(a1[0]) - Integer.parseInt(a1[2]) == Integer.parseInt(a1[4])){
                    answer[i] = "O";
                }else{
                    answer[i] = "X";
                }
            }else if(a1[1].equals("+")){
                System.out.println(a1[0] + "+" + a1[2] + "=" + a1[4]);
                if(Integer.parseInt(a1[0]) + Integer.parseInt(a1[2]) == Integer.parseInt(a1[4])){
                    answer[i] = "O";
                }else{
                    answer[i] = "X";
                }   
            }
        }
        return answer;
    }
}