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

	//배양액을 뿌릴 수 있는 땅에서 현재 주어진 배양액의 총량 만큼 조합
	//만들어진 조합에서 배양액을 뿌리는 순서에 대한 조합 추출
	//만들어진 케이스를 시뮬레이션 실행
	static int N, M, map[][], G, R, max = Integer.MIN_VALUE, sSize, res[];
	static List<int[]> gr = new ArrayList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		sSize = G + R;
		map = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < M; j++){
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp == 2) {
					gr.add(new int[] {i,j});
				}
			}
		}
		int size = gr.size();
		res = new int[size];
		combi(0, G, R, size - sSize, size); //시뮬레이션 조합 생성
		System.out.println(max);
	}
	//심을 수 있는 땅의 갯수에서 빨간배양액을 심을 땅, 초록배양액을 심을 땅, 아무것도 심지않을 땅에 대한
	//경우의수를 생성
	static void combi(int cnt, int g, int r, int non, int size) {
		if(cnt == size) {//기제조건
//			System.out.println(Arrays.toString(res));
			toDo(map, size); //완성된 조합을 바탕으로 시뮬레이션 진행
			return;				
		}

		if(non > 0) { //심지않는 경우
			combi(cnt + 1,g,r,non-1, size);			
		}
		if(g > 0) { //초록배양액을 심는경우
			res[cnt] = 1;
			combi(cnt + 1, g - 1, r,non, size);
		}
		if(r > 0) { //빨간 배양액을 심는경우
			res[cnt] = 2;
			combi(cnt + 1, g, r - 1,non, size);
		}
		res[cnt] = 0; //리턴시 값 초기화
	}
	
	//매초마다 상하좌우 번식
	//빨강 초록이 동시에 번식을 시도할때 꽃이 핀다.
	static void toDo(int[][] map, int size) {
		Queue<int[]> q = new ArrayDeque<int[]>(); //배양엑이 퍼져나가는 걸 구현하기 위한 큐

		int[][][] f = new int[N][M][4];

		
		for(int i = 0; i < size; i++) {
			if(res[i] == 1) {
				int x = gr.get(i)[0];
				int y = gr.get(i)[1];
				q.offer(new int[] {x,y,res[i]});
				f[x][y] = new int[] {1,0,0,0};
			}else if(res[i] == 2) {
				int x = gr.get(i)[0];
				int y = gr.get(i)[1];
				q.offer(new int[] {x,y,res[i]});
				f[x][y] = new int[] {0,1,0,0};				
			}
		}
		
		int cnt = 0;
		int count = 0;
		int dx[] = new int[] {-1,1,0,0};
		int dy[] = new int[] {0,0,-1,1};
		while(!q.isEmpty()) {
			cnt++;
			int qsize = q.size();
			for(int i = 0; i < qsize; i++) {
				int tmp[] = q.poll();
//				System.out.println(Arrays.toString(tmp));
				int x = tmp[0];
				int y = tmp[1];
				if(f[x][y][0] == 2) {
					continue;
				}
				if(tmp[2] == 1) {
					for(int j = 0; j < 4; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if(nx >= 0 && nx < N && ny >= 0 && ny < M && f[nx][ny][0] != 1 && map[nx][ny] != 0) {
//							System.out.println(nx + " " + ny);
							if(f[nx][ny][1] == 1 && f[nx][ny][3] == cnt) {
								count++;
								f[nx][ny] = new int[] {2,2,2,2};
							}else if(f[nx][ny][1] == 1 && f[nx][ny][3] != cnt){
								f[nx][ny][0] = 1;
								continue;
							}else if(f[nx][ny][1] == 0) {
								f[nx][ny][0] = 1;
								f[nx][ny][2] = cnt;
								q.offer(new int[] {nx,ny,1});
							}
//							System.out.println(Arrays.toString(f[nx][ny]));
						}
					}
				}else {
					for(int j = 0; j < 4; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if(nx >= 0 && nx < N && ny >= 0 && ny < M && f[nx][ny][1] != 1 && map[nx][ny] != 0) {
//							System.out.println(nx + " " + ny);
							if(f[nx][ny][0] == 1 && f[nx][ny][2] == cnt) {
								count++;
								f[nx][ny] = new int[] {2,2,2,2};
							}else if(f[nx][ny][0] == 1 && f[nx][ny][2] != cnt){
								f[nx][ny][1] = 1;
								continue;
							}else if(f[nx][ny][0] == 0) {
								f[nx][ny][1] = 1;
								f[nx][ny][3] = cnt;
								q.offer(new int[] {nx,ny,2});
							}
//							System.out.println(Arrays.toString(f[nx][ny]));
						}
					}
				}
			}
		}
		if(max < count) {
			max = count;
		}
	}
}
