import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][], shark[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		shark = new int[3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp == 9) {
					shark = new int[] {i,j,2};
				}
			}
		}
		
		toDo(shark[0], shark[1], shark[2], 0, 0, map, N);
	}
	

	static void toDo(int x, int y, int s, int eat, int time, int map[][], int N) { 
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					if(o1[1] == o2[1]) {
						return o1[2] - o2[2];
					}
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		int dx[] = new int[] {-1,0,1,0};
		int dy[] = new int[] {0,-1,0,1};
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] v = new boolean[N][N];
		q.offer(new int[] {x,y});
		v[x][y] = true;
		
		int l = 0;
		
		while(!q.isEmpty()) {
			l++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int temp[] = q.poll();
				int cx = temp[0];
				int cy = temp[1];
				for(int j = 0; j < 4; j++) {
					int nx = cx + dx[j];
					int ny = cy + dy[j];
					if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if(map[nx][ny] > s) {
							continue;
						}
						if((map[nx][ny] == s || map[nx][ny] == 0) && !v[nx][ny]) {
							q.offer(new int[] {nx, ny});
							v[nx][ny] = true;
						}else if(map[nx][ny] < s && map[nx][ny] != 0 && !v[nx][ny]) {
		
							pq.offer(new int[] {l, nx, ny});
						}
					}
				}
			}
			if(!pq.isEmpty()) {
				break;
			}
		}
		
		if(pq.isEmpty()) {
			System.out.println(time);
			return;
		}else {
			int canEat[] = pq.poll();
			map[x][y] = 0;
			map[canEat[1]][canEat[2]] = 9;
			
			if(eat + 1 == s) {
				toDo(canEat[1], canEat[2], s + 1, 0, time + canEat[0], map, N);		
			}else {
				toDo(canEat[1], canEat[2], s, eat + 1, time + canEat[0], map, N);						
			}
		}
	}
}
