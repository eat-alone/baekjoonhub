import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[][], res[],min = Integer.MAX_VALUE;
	static boolean[] v;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][N];
		res = new int[N];
		v = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		toDo(0);
		System.out.println(min);
	}
	
	static void toDo(int cnt) {
		if(cnt == N) {
			toDo2();
			return;
		}
		for(int i = 0; i < N; i++) {
			if(v[i]) {
				continue;
			}
			
			v[i] = true;
			res[cnt] = i;
			toDo(cnt + 1);
			v[i] = false;
		}
	}

	static void toDo2() {
		int sum = 0;
//		System.out.println(Arrays.toString(res));
		for(int i = 0; i < N; i++) {
			if(i + 1 == N) {
//				System.out.print(arr[i][0]+ " ");
				if(arr[res[i]][res[0]] == 0) {
					sum = Integer.MAX_VALUE;
					break;
				}else {
					sum += arr[res[i]][res[0]];
					break;
				}
			}
//			System.out.print(arr[i][i + 1]+ " ");
			if(arr[res[i]][res[i+1]] == 0) {
				sum = Integer.MAX_VALUE;
				break;
			}else {
				sum += arr[res[i]][res[i+1]];
			}
			if(sum > min) {
				return;
			}
		}
//		System.out.println();
		if(min > sum) {
			min = sum;
		}
	}
}
