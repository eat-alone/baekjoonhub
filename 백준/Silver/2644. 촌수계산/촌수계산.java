import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, x, y;
	static List<int[]> list[];
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		list = new ArrayList[N+1];
		v = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<int[]>();
			list[i].add(new int[N+1]);
		}
		StringTokenizer st = new StringTokenizer(bf.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		
		M = Integer.parseInt(bf.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken());
			
			list[ny].get(0)[nx] = 1;
			list[nx].get(0)[ny] = 1;			
		}
		
		toDo();
	}
	
	static void toDo() {
		Queue<List> q = new ArrayDeque<List>();
		
		q.offer(list[y]);
		v[y] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for(int i = 0; i < size; i++) {
				List<int[]> temp = q.poll();
				if(temp.get(0)[x] == 1) {
					System.out.println(cnt);
					return;
				}else {
					for(int j = 1; j < N; j++) {
						if(!v[j] && temp.get(0)[j] == 1) {
							q.offer(list[j]);
							v[j] = true;
						}
					}
				}
			}
		}
		System.out.println(-1);
		return;
	}
}
