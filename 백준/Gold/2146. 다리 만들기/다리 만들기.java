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
	static int N, map[][], min = Integer.MAX_VALUE;
	static boolean visit[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					visit[i][j] = true;
					toDo(i,j);
				}
			}
		}
		
		System.out.println(min - 1);
	}
	//맵에 00부터 nn까지 toDo 돌린다 맵 ij가 1이라면 섬의 시작부분
	//시작부분에서 섬이 어디까지 있는지 상하좌우로 체크한다.
	//상하좌우 중 바다를 만난다면 바다에서부터 다른 섬을 만날때까지 탐색 시작
	//가장짧은 다리가 생성되면 종료 작은 값 갱신
	
	static Queue<int[]> bridge = new ArrayDeque<>();
	static void toDo(int r, int c) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		boolean[][] visited = new boolean[N][N]; //현재섬인지를 구분하는 부울린
		
		visited[r][c] = true;
		q.offer(new int[] {r,c});
		
		int dx[] = new int[] {-1,1,0,0};
		int dy[] = new int[] {0,0,-1,1};
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			int v = 0; //바다를만났는지 체크
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]) {
					if(map[nx][ny] == 1) {
						visit[nx][ny] = true; //모든 섬에 대한 방문체크 부울린
						visited[nx][ny] = true;
						q.offer(new int[] {nx,ny});
					}else {
						if(v == 0) {
							bridge.offer(new int[] {x,y});			
							v = 1; //바다가 여러면일 경우 한면에 대한 좌표값만 입력
						}
					}
				}
			}
		}
//		int[][] map2 = new int[N][N];
//		while(!bridge.isEmpty()) {
//			int temp[] = bridge.poll();
//			map2[temp[0]][temp[1]] = 1;
//		}
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map2[i]));
//		}
//		System.out.println();
		toDo2(visited);
	}
	
	
	
	static void toDo2(boolean[][] visit) {
		
		int [] dx = new int[] {-1,1,0,0};
		int [] dy = new int[] {0,0,-1,1};
		
		while(!bridge.isEmpty()) {
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(bridge.poll());
			int cnt = 0;
			boolean[][] v = new boolean[N][N];
			a : while(!q.isEmpty()) {
				cnt++;
				if(cnt > min) {
					break;
				}
				int size = q.size();
				for(int i = 0; i < size; i++) {
					int temp[] = q.poll();
					int x = temp[0];
					int y = temp[1];
					for(int j = 0; j < 4; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && !v[nx][ny]) {
							if(map[nx][ny] == 1) {
								if(min > cnt) {
									min = cnt;
								}
								break a;
							}else {
								v[nx][ny] = true;
								q.offer(new int[] {nx,ny});
							}
						}
					}
				}
			}
		}
	}
}
