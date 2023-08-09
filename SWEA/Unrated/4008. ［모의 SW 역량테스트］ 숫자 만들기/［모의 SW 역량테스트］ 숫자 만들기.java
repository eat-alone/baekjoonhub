import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int N, SUM, MAX, MIN;
	static int O[] = new int[4];
	static int NUM[];
	static int res[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());

		for(int tc = 1; tc <= T; tc++) {
			MIN = Integer.MAX_VALUE;
			MAX = Integer.MIN_VALUE;
			SUM = 0;
			N = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			for(int i = 0; i < 4; i++) {
				O[i] = Integer.parseInt(st.nextToken());
				SUM = SUM + O[i];
			}
			res = new int[SUM];
			NUM = new int[N];
			st = new StringTokenizer(bf.readLine());
			for(int i = 0; i < N; i++) {
				NUM[i] = Integer.parseInt(st.nextToken());
			}
			toDo(0);
			System.out.println("#" + tc + " " + (MAX - MIN));
		}
	}

	static void toDo(int cnt) {
		if(cnt == SUM) {
			int result = doSum();
			if(result > MAX) {
				MAX = result;
			}
			if(MIN > result) {
				MIN = result;
			}
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(O[i] == 0) {
				continue;
			}
			res[cnt] = i;
			O[i]--;
			toDo(cnt + 1);
			O[i]++;
		}
	}

	private static int doSum() {
		int result = NUM[0];
		int idx = 1;
		for(int i = 0; i < SUM; i++) {
			switch (res[i]) {
			case 0:
				result += NUM[idx]; 
				break;
			case 1:
				result -= NUM[idx];
				break;
			case 2:
				result *= NUM[idx];
				break;
			case 3:
				result /= NUM[idx];
				break;
			}
			idx++;
		}
		return result;
	}
}
