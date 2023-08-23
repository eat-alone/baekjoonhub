import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, arr[], sum, lsum,rsum;
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sum = 0;
			N = Integer.parseInt(bf.readLine());
			v = new boolean[N];
			arr = new int[N];
			st = new StringTokenizer(bf.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			toDo(0,0,0,v, arr, N);
			System.out.println("#" + tc + " " + sum);
		}
	}
	
	static void toDo(int cnt, int rsum, int lsum, boolean[] v, int[] arr, int N) {
		if(cnt == N) {
			sum++;
			return;
		}
		for(int i = 0; i < N; i++) {
			if(v[i]) {
				continue;
			}
			v[i] = true;
			if(rsum + arr[i] <= lsum) {
				toDo(cnt + 1, rsum + arr[i], lsum, v, arr, N);
			}
			toDo(cnt + 1, rsum, lsum + arr[i], v, arr, N);
			v[i] = false;
		}
	}
	
	

}
