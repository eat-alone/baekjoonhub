import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int size = input.length();
        int[] alpa = new int[26];
        for(int i = 0; i < size; i++){
            char c = input.charAt(i);
            if(c < 91){
                alpa[c - 65]++;
            }else{
                alpa[c - 97]++;
            }
        }

        int max = 0;
        int index = 0;
        int flag = 0;
        for(int i = 0; i < 26; i++){
            if(max == alpa[i]){
                flag = 1;
                continue;
            }
            if(alpa[i] > max){
                flag = 0;
                max = alpa[i];
                index = i;
            }
        }

        if(flag == 1){
            System.out.println("?");
        }else{
            System.out.println((char)(index+65));
        }
        
    }
}
