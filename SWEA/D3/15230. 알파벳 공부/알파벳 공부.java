import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		int answer;
        String n;
        String alpha = "abcdefghijklmnopqrstuvwxyz";
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.print("#" + test_case + " ");
			n = sc.next();
			answer = 0;
			for(int i = 0; i < n.length(); i++) {
				if(alpha.charAt(i) == n.charAt(i)) {
					answer++;
				}else {
					break;
				}
			}
			System.out.println(answer);
		}
	}
}