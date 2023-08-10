import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, Tcal, MAX;
	static int[][] info;
	static boolean[] v;
	static int[] SUM;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			SUM = new int[2];
			MAX = 0;
			
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			Tcal = Integer.parseInt(st.nextToken());
			
			info = new int[N][2];
			v = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				info[i][0] = Integer.parseInt(st.nextToken());
				info[i][1] = Integer.parseInt(st.nextToken());
			}
			toDo(0);
			System.out.println("#" + tc + " " + MAX);
		}
	}
	
	static void toDo(int cnt) {
		if(cnt == N) {
			if(SUM[1] > Tcal) {
				return;
			}else {
				if(SUM[0] > MAX) {
					MAX = SUM[0];
				}
			}
			return;
		}
		v[cnt] = true;
		SUM[0] += info[cnt][0];
		SUM[1] += info[cnt][1];
		toDo(cnt + 1);
		v[cnt] = false;
		SUM[0] -= info[cnt][0];
		SUM[1] -= info[cnt][1];
		toDo(cnt + 1);
	}

}
