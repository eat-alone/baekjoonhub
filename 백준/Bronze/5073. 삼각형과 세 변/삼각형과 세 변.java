import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            int a, b, c;

            int[] in = new int[3];

            st = new StringTokenizer(bf.readLine());

            for(int i = 0; i < 3; i++){
                in[i] = Integer.parseInt(st.nextToken());
            }

            a = in[0];
            b = in[1];
            c = in[2];

            if(a == 0 && b == 0 && c ==0){
                break;
            }

            if(a == b && b == c){
                System.out.println("Equilateral");
            }else if(a == b && a + b > c){
                System.out.println("Isosceles ");
            }else if(a == c && a + c > b){
                System.out.println("Isosceles ");
            }else if(b == c && b + c > a){
                System.out.println("Isosceles ");
            }else if(a + b <= c || b + c <= a || a + c <= b){
                System.out.println("Invalid");
            }else{
                System.out.println("Scalene");
            }
        }
    }
}
