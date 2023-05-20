import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
        char n;
        String answer;
        String answer2;
        int n1;
        int n2;
        int n3;
        char[][] arr = new char[8][8];
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer = " ";
			answer2 = "yes";
            n3 = 0;
			System.out.print("#"+test_case+" ");
			for(int i = 0; i < 8; i++) {
				answer = sc.next();
				for(int j = 0; j < 8; j++) {
					n = answer.charAt(j);
                    if(n == 'O'){
                    	n3++;
                    }
					arr[i][j] = n;
				}
			}
			if(n3 != 8) {
				answer2 = "no";
			}else if(n3 == 8) {
				for(int i = 0; i < 8; i++) {
					n1 = 0;
					n2 = 0;
					for(int j = 0; j < 8; j++) {
						if(arr[i][j] == 'O') {
							n1++;
						}
						if(arr[j][i] == 'O') {
							n2++;
						}
					}
					if(n1 > 1 || n2 > 1) {
						answer2 = "no";
						break;
					}
				}
			}
			System.out.println(answer2);
		}
	}
}