import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
        int n;
        int num;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			num = 0;
			n = sc.nextInt();
			System.out.print("#"+test_case+" ");
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(i*i + j*j <= n*n) {
						num++;
					}
				}
			}
			System.out.println(num*4+n*4+1);
		}
	}
}
