class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] answer1 = {};
        String temp1 = "";
        int temp = 1;
        for(int i = 0; i < letter.length(); i++){
            if(letter.charAt(i) == ' '){
                temp++;
            }
        }
        answer1 = new String[temp];
        temp = 0;
        for(int i = 0; i < answer1.length; i++){
            for(int j = temp; j < letter.length(); j++){
                if(letter.charAt(j) == ' '){
                    for(int k = temp; k < j; k++){
                        temp1 += Character.toString(letter.charAt(k));
                        temp = j+1;
                    }
                    answer1[i] = temp1;
                    temp1 = "";
                    break;
                }
            }
        }
        for(int i = temp; i < letter.length(); i++){
            temp1 += Character.toString(letter.charAt(i));
        }
        answer1[answer1.length - 1] = temp1;
        for(int i = 0; i < answer1.length; i++){
            if (answer1[i].equals(".-")) answer += "a";
            if (answer1[i].equals("-...")) answer += "b";
            if (answer1[i].equals("-.-.")) answer += "c";
            if (answer1[i].equals("-..")) answer += "d";
            if (answer1[i].equals(".")) answer += "e";
            if (answer1[i].equals("..-.")) answer += "f";
            if (answer1[i].equals("--.")) answer += "g";
            if (answer1[i].equals("....")) answer += "h";
            if (answer1[i].equals("..")) answer += "i";
            if (answer1[i].equals(".---")) answer += "j";
            if (answer1[i].equals("-.-")) answer += "k";
            if (answer1[i].equals(".-..")) answer += "l";
            if (answer1[i].equals("--")) answer += "m";
            if (answer1[i].equals("-.")) answer += "n";
            if (answer1[i].equals("---")) answer += "o";
            if (answer1[i].equals(".--.")) answer += "p";
            if (answer1[i].equals("--.-")) answer += "q";
            if (answer1[i].equals(".-.")) answer += "r";
            if (answer1[i].equals("...")) answer += "s";
            if (answer1[i].equals("-")) answer += "t";
            if (answer1[i].equals("..-")) answer += "u";
            if (answer1[i].equals("...-")) answer += "v";
            if (answer1[i].equals(".--")) answer += "w";
            if (answer1[i].equals("-..-")) answer += "x";
            if (answer1[i].equals("-.--")) answer += "y";
            if (answer1[i].equals("--..")) answer += "z";
        }
        return answer;
    }
}