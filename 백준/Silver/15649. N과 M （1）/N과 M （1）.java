import java.util.Scanner;

public class Main {
	static int N;
	static int R;
	static int[] arr;
	static boolean[] v;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		v = new boolean[N];
		arr = new int[R];
		term(0);
	}
	
	static void term(int i) {
		if(i >= R) {
			for(int j = 0; j < R; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
			return;
		}
		for(int j = 1; j < N + 1; j++) {
			if(v[j - 1]) {
				continue;
			}
			arr[i] = j;
			v[j - 1] = true;
			term(i + 1);
			v[j - 1] = false;
		}
	}
}
