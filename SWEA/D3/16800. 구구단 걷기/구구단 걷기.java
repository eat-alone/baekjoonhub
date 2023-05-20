import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
        long n;
        long n1 = 0;
        int num;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			ArrayList<Long> arr = new ArrayList<>();
			num = 0;
			n = sc.nextLong();
			n1 = (long)Math.sqrt(n);
			System.out.print("#"+test_case+" ");
			for(long i = 1; i <= n1; i++) {
				if(n % i == 0) {
					arr.add(i);
					arr.add(n/i);
				}
			}
			arr.sort(Comparator.naturalOrder());
			System.out.println(arr.get(arr.size()/2) + arr.get(arr.size()/2 - 1) - 2);
		}
	}
}
