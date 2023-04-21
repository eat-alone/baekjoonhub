class Solution {
    public int solution(int price) {
        int answer = 0;
        float temp = (float)price;
        float discount = 0.0f;
        if(price >= 500000){
            discount = 0.8f;
            temp = temp * discount;
            answer = (int)temp;
        }else if (price >= 300000){
            discount = 0.9f;
            temp = temp * discount;
            answer = (int)temp;
        }else if (price >= 100000){
            discount = 0.95f;
            temp = temp * discount;
            answer = (int)temp;
        }else{
            answer = price;
        }
        return answer;
    }
}