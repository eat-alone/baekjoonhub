class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        System.out.println("0-1선분기울기 :" + Double.valueOf(dots[0][0] - dots[1][0]) / Double.valueOf(dots[0][1] - dots[1][1]));
        System.out.println("2-3선분기울기 :" + Double.valueOf(dots[2][0] - dots[3][0]) / Double.valueOf(dots[2][1] - dots[3][1]));
        System.out.println("0-2선분기울기 :" + Double.valueOf(dots[0][0] - dots[2][0]) / Double.valueOf(dots[0][1] - dots[2][1]));
        System.out.println("1-3선분기울기 :" + Double.valueOf(dots[1][0] - dots[3][0]) / Double.valueOf(dots[1][1] - dots[3][1]));
        System.out.println("0-3선분기울기 :" + Double.valueOf(dots[0][0] - dots[3][0]) / Double.valueOf(dots[0][1] - dots[3][1]));
        System.out.println("1-2선분기울기 :" + Double.valueOf(dots[1][0] - dots[2][0]) / Double.valueOf(dots[1][1] - dots[2][1]));
        if(Double.valueOf(dots[0][0] - dots[1][0]) / Double.valueOf(dots[0][1] - dots[1][1]) == Double.valueOf(dots[2][0] - dots[3][0]) / Double.valueOf(dots[2][1] - dots[3][1])){
            answer = 1;
        }else if(Double.valueOf(dots[0][0] - dots[2][0]) / Double.valueOf(dots[0][1] - dots[2][1]) == Double.valueOf(dots[1][0] - dots[3][0]) / Double.valueOf(dots[1][1] - dots[3][1])){
            answer = 1;
        }else if(Double.valueOf(dots[0][0] - dots[3][0]) / Double.valueOf(dots[0][1] - dots[3][1]) == Double.valueOf(dots[1][0] - dots[2][0]) / Double.valueOf(dots[1][1] - dots[2][1])){
            answer = 1;
        }
        return answer;
    }
}