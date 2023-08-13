import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, res[];
	static boolean[] v;
	public static void main(String[] args) {
		//리스트 N 개 중에서 R 개를 선택해서 순열 생성
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		v = new boolean[N];
		res = new int[N];
		toDo(0);
	}
	
	static void toDo(int cnt) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < N; i++) {
			if(v[i]) {
				continue;
			}
			res[cnt] = i + 1;
			v[i] = true;
			toDo(cnt + 1);
			v[i] = false;
		}
	}

}
