import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(bf.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int map[][] = new int[M][N];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			boolean v[][] = new boolean[M][N];
			int cnt = 0;
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1 && !v[i][j]) {
						v[i][j] = true;
						cnt++;
						bfs(i,j,map,v, N, M);
					}
				}
			}
			sb.append(cnt).append("\n");
			
		}
		System.out.println(sb);
	}
	static void bfs(int x, int y, int map[][], boolean v[][], int N, int M) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {x, y});
		int dx[] = new int[] {-1,1,0,0};
		int dy[] = new int[] {0,0,-1,1};
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(nx >= 0 && ny >= 0 && nx < M && ny < N && !v[nx][ny] && map[nx][ny] == 1) {
					v[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
}
