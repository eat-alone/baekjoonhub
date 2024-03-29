import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    static List[] list;
    static boolean[] v;
    static Set<Integer> set = new HashSet<>();
    static public int solution(String[] user_id, String[] banned_id) {
        list = new ArrayList[banned_id.length];
        v = new boolean[user_id.length];
        for(int i = 0; i < banned_id.length; i++){
            list[i] = new ArrayList<Integer>();
        }

        //각 제제아이디에 해당하는 모든 유저 아이디의 번호를 찾는다.
        for(int i = 0; i < banned_id.length; i++){
            for(int j = 0; j < user_id.length; j++){
                //제제아이디 배열의 i 번째와 user 배열의 j 번째의 길이가 같은지 확인
                if(banned_id[i].length() == user_id[j].length()){
                    boolean flag = true;
                    //길이가 같다면 각 자리 비교
                    for(int k = 0; k < banned_id[i].length(); k++){
                        //각자리의 문자열이 일치한다면 판단 변수가 변하지 않고
                        if(banned_id[i].charAt(k) == '*' || banned_id[i].charAt(k) == user_id[j].charAt(k)){
                            continue;
                        }else{
                            //한자리라도 다르다면 판단변수가 다름을 판단
                            flag = false;
                        }
                    }

                    //비교 결과 제제 아이디에 해당한다면 저장
                    if(flag) {
                        list[i].add(j);
                    }
                }
            }
        }
        //가능한 조합들을 생성한다.
        combi(0, banned_id.length, 1);
        //중복은 각 아이디들의 합으로 구별
        return set.size();
    }



    static public void combi(int cnt, int count, int sum){
        if(cnt == count){
            set.add(sum);
            return;
        }

        for(int i = 0; i < list[cnt].size(); i++){
            if(v[(int) list[cnt].get(i)]){
                continue;
            }
            v[(int) list[cnt].get(i)] = true;
            combi(cnt + 1, count, sum+(int) list[cnt].get(i)*(int) list[cnt].get(i)*(int) list[cnt].get(i));
            v[(int) list[cnt].get(i)] = false;
        }
    }
}