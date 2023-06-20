class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int serv = 0;
        while(true){
            serv = serv + chicken % 10;
            chicken = chicken / 10;
            System.out.println("chicken : " + chicken + "  serv : " + serv);
            answer = answer + chicken;
            if(serv >= 10){
                answer = answer + serv / 10;
                serv = serv / 10 + serv % 10;
            }
            if(chicken < 10){
                serv = serv + chicken % 10;
                break;
            }
        }
        if(serv >= 10){
            answer = answer + serv / 10;
        }
        System.out.println("chicken : " + chicken + "  serv : " + serv);
        return answer;
    }
}