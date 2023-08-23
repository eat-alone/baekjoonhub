import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N,M, p[];
	static long sum;
	static List<int[]> list;
	
	static void make() {
		p = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}
	
	static int find(int a) {
		if(a == p[a]) {
			return a;
		}
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		p[bRoot] = aRoot;
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sum = 0;
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			make();
			list = new ArrayList<int[]>();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				list.add(new int[] {from, to, weight});
			}
			
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2] - o2[2];
				}
			});
			int cnt = 0;
			for(int[] a : list) {
				if(cnt == N - 1) {
					break;
				}
				if(union(a[0], a[1])) {
					sum += a[2];
					cnt++;
				}
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}

}
