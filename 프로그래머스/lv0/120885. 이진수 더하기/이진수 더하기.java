class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        char[] an1 = {};
        char[] an2 = {};
        char[] an3 = {};
        int temp = 0;
        int temp2 = 0;
        int temp3 = 0;
        if(bin1.length() > bin2.length()){
            temp3 = bin1.length() - bin2.length();
            an3 = new char[bin1.length() + 1];
            an1 = bin1.toCharArray();
            an2 = new char[bin1.length()];
            for(int j = 0; j < temp3; j++){
                an2[j] = '0';
            }
            for(int i = temp3; i < bin1.length(); i++){
                an2[i] = bin2.charAt(i - temp3);
            }
            temp2 = bin1.length();
        }else if(bin1.length() < bin2.length()){
            temp3 = bin2.length() - bin1.length();
            an3 = new char[bin2.length() + 1];    
            an2 = bin2.toCharArray();
            an1 = new char[bin2.length()];
            for(int j = 0; j < temp3; j++){
                an1[j] = '0';
            }
            for(int i = temp3; i < bin2.length(); i++){
                an1[i] = bin1.charAt(i - temp3);
            }
            temp2 = bin2.length();
        }else{
            an3 = new char[bin1.length() + 1];
            an1 = new char[bin1.length()];
            an2 = new char[bin1.length()];
            an1 = bin1.toCharArray();
            an2 = bin2.toCharArray();
            temp2 = bin1.length();
        }
        for(int i = temp2 - 1; i > -1; i--){
            if(an1[i]-'0' == 0 && an2[i]-'0' == 0 && temp == 0){
                an3[temp2] = '0';
                temp2--;
            }else if(an1[i]-'0' == 0 && an2[i]-'0' == 0 && temp == 1){
                an3[temp2] = '1';
                temp = 0;
                temp2--;
            }else if(an1[i]-'0' == 1 && an2[i]-'0' == 1 && temp == 0){
                an3[temp2] = '0';
                temp = 1;
                temp2--;
            }else if(an1[i]-'0' == 1 && an2[i]-'0' == 1 && temp == 1){
                an3[temp2] = '1';
                temp = 1;
                temp2--;
            }else if(an1[i]-'0' == 0 && an2[i]-'0' == 1 && temp == 0){
                an3[temp2] = '1';
                temp2--;
            }else if(an1[i]-'0' == 0 && an2[i]-'0' == 1 && temp == 1){
                an3[temp2] = '0';
                temp = 1;
                temp2--;
            }else if(an1[i]-'0' == 1 && an2[i]-'0' == 0 && temp == 0){
                an3[temp2] = '1';
                temp2--;
            }else if(an1[i]-'0' == 1 && an2[i]-'0' == 0 && temp == 1){
                an3[temp2] = '0';
                temp = 1;
                temp2--;
            }
        }
        if(temp == 1){
            an3[temp2] = '1';
            answer = new String(an3);
        }else{
            an3[temp2] = ' ';
            answer = new String(an3);
            answer = answer.substring(1);
        }
        return answer;
    }
}