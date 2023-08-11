import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//N킬로그램 설탕 배달
		//3킬로 5킬로 봉지 있음 최대한 적은 봉투로 N킬로그램을 옮겨야한다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int an = -1;
		int[] a = new int[2];

		a[0] = N / 5;
		N = N % 5;
		if(N == 0) {
			an = a[0];
		}else {
			if(N % 3 != 0) {
				int idx = a[0];
				for(int i = 0; i < idx; i++) {
					N += 5;
					a[0]--;
					if(N % 3 == 0) {
						a[1] = N / 3;
						an = a[0] + a[1];
						break;
					}
				}
			}else {
				a[1] = N / 3;
				an = a[0] + a[1];
			}
		}
		
		System.out.println(an);
	}
}
