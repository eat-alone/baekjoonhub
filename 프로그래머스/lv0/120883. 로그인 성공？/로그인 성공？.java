class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        for(int i = 0; i < db.length; i++){
            if(db[i][0].length() == id_pw[0].length() && db[i][0].equals(id_pw[0])){
                if(db[i][1].length() == id_pw[1].length() && db[i][1].equals(id_pw[1])){
                    answer = "login";
                    return answer;
                }else{
                    answer = "wrong pw";
                    return answer;
                }
            }
        }
        return answer;
    }
}