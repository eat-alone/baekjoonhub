import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bf.readLine());
        //1
        //2~7 = 6
        //8~19 = 12
        //20~37 = 18
        //38~61 = 24
        int i = 1;
        int sum = 1;
        while(true){
            if(target <= sum){
                System.out.println(i);
                break;
            }else{
                sum = sum + (i * 6);
                i++;
            }
        }
    }
}
