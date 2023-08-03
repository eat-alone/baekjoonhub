import java.util.Scanner;

public class Main {
	static int[] arr = new int[9];
	static int[] res = new int[7];
	static boolean[] v = new boolean[9];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		combi(0, 0, 0);
	}
	static void combi(int cnt, int result, int start) {
		if(cnt == 7) {
			for(int i = 0; i < cnt; i++) {
				result += res[i];
			}
			if(result == 100) {
				for(int i = 0; i < cnt; i++) {
					System.out.print(res[i] + " ");
				}
				System.out.println();
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			if(v[i]) {
				continue;
			}
			res[cnt] = arr[i];
			v[i] = true;
			combi(cnt+1, result, i);
			v[i] = false;
		}
	}
}
