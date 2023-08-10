import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int carcList[][];
	static boolean[] v;
	static int[] selection;
	static int N, M, R;
	static int count, MIN;
	static Queue<Integer> q[];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		MIN = Integer.MAX_VALUE;
		map = new int[N+1][M+1];
		carcList = new int[R][3];
		v = new boolean[R];
		selection = new int[R];
//		System.out.println();
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < 3; j++) {
				carcList[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(carcList[i]));
		}
		select(0);
		System.out.println(MIN);
	}
	static void spin() {
		int temp[][] = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			temp[i] = Arrays.copyOf(map[i], M+1);
		}
		for(int i = 0; i < R; i++) {
			int x1 = carcList[selection[i]][0] - carcList[selection[i]][2];
			int y1 = carcList[selection[i]][1] - carcList[selection[i]][2];
			int x2 = carcList[selection[i]][0] + carcList[selection[i]][2];
			int y2 = carcList[selection[i]][1] + carcList[selection[i]][2];
//			System.out.println("x1 : "  + x1 + " //y 1 : " + y1 + " //x2 : " + x2 + " //y2 : " + y2);
			int temp2[][] = new int[x2 - x1 + 1][y2 - y1 + 1];
			for(int j = 0; j < temp2.length; j++) {
				temp2[j] = Arrays.copyOfRange(temp[x1+j], y1, y2 + 1);
//				System.out.println(Arrays.toString(temp2[j]));
			}
			if(temp2.length > temp2[0].length) {
				count = temp2[0].length / 2 + 1;				
			}else {				
				count = temp2.length / 2 + 1;				
			}
//			System.out.println(count);
			q = new Queue[count];
			for(int j = 0; j < q.length; j++) {
				q[j] = new ArrayDeque<Integer>();
			}
			todo(0,0,0,temp2.length,temp2[0].length,0,temp2);
			for(int j = 0; j < count; j++) {
				((ArrayDeque<Integer>) q[j]).offerFirst(((ArrayDeque<Integer>) q[j]).pollLast());
			}
			todo2(0,0,0,temp2.length,temp2[0].length,0,temp2);
//			System.out.println();
//			for(int j = 0; j < temp2.length; j++) {
//				System.out.println(Arrays.toString(temp2[j]));
//			}
			
			for(int j = 0; j < temp2.length; j++) {
				for(int k = 0; k < temp2[0].length; k++) {
					temp[x1+j][y1+k] = temp2[j][k];
				}
			}
			
		}
//		for(int i = 0; i < temp.length; i++) {
//			System.out.println(Arrays.toString(temp[i]));
//		}
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < temp.length; i++) {
			int sum = 0;
			for(int j = 1; j < temp[0].length; j++) {
						sum += temp[i][j];
			}
			if(min > sum) {
				min = sum;
			}
		}
		if(MIN > min) {
			MIN = min;
		}
	}
	static void todo(int cnt, int x, int y, int n, int m, int idx, int[][] map) {
		if(cnt == count) {
			return;
		}
		int x1 = x;
		int y1 = y;
		while(true) {
//			System.out.println(x1 + " " + y1);
			q[idx].offer(map[x1][y1]);
			map[x1][y1] = 0;
			if(y1 + 1 < m && map[x1][y1 + 1] !=0) {
				y1++;
			}else if(x1 + 1 < n && map[x1 + 1][y1] != 0) {
				x1++;
			}else if(y1 - 1 >= y && map[x1][y1 - 1] != 0) {
				y1--;
			}else {
				while(map[x1 - 1][y1] != 0) {
//					System.out.println("else");
					x1--;
//					System.out.println(map[x1][y1]);
					q[idx].offer(map[x1][y1]);
					map[x1][y1] = 0;
				}
				todo(cnt + 1, x + 1, y + 1, n - 1, m -1, idx + 1, map);
				break;
			}
		}
	}
	static void todo2(int cnt, int x, int y, int n, int m, int idx, int[][] map) {
		if(cnt == count) {
			return;
		}
		int x1 = x;
		int y1 = y;
		while(true) {
			map[x1][y1] = q[idx].poll();
			if(y1 + 1 < m && map[x1][y1 + 1] == 0) {
				y1++;
			}else if(x1 + 1 < n && map[x1 + 1][y1] == 0) {
				x1++;
			}else if(y1 - 1 >= y && map[x1][y1 - 1] == 0) {
				y1--;
			}else {
				while(map[x1 - 1][y1] == 0) {
					x1--;
					if(!q[idx].isEmpty()) {
						map[x1][y1] = q[idx].poll();						
					}
				}
				todo2(cnt + 1, x + 1, y + 1, n - 1, m -1, idx + 1, map);
				break;
			}
		}
	}
	static void select(int cnt) {
		if(cnt == R) {
			//System.out.println(Arrays.toString(selection));
			spin();
			return;
		}
		for(int i = 0; i < R; i++) {
			if(v[i]) {
				continue;
			}
			selection[cnt] = i;
			v[i] = true;
			select(cnt + 1);
			v[i] = false;
		}
	}
}
