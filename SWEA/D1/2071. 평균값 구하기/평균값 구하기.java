import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
        int n;
        double num;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			num = 0;
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < 10; i++){
            	n = sc.nextInt();
            	num = num + n;
            }
			System.out.println(String.format("%.0f", num / 10));
		}
	}

}
