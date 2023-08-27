import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.print.attribute.standard.PrintQuality;

public class Solution {
	static int N,map[][],res[],res2[], max, size;
	static boolean[] v;
	static List<int[]> list;
	static List<int[]> search;
	static PriorityQueue<int[]> pq;

public static void main(String[] args) throws NumberFormatException, IOException {
	//이미 가장자리에 있는 코어를 제외하고
	//각 코어마다 네방위 중 나올 수 있는 순열 생성 후 시뮬레이션
	//전선 길이의 합이 최소가 되는 경우 탐색
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	int T = Integer.parseInt(bf.readLine());

	for(int tc = 1; tc <= T; tc++) {
		max = Integer.MIN_VALUE;
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		list = new ArrayList<int[]>();
		search = new ArrayList<int[]>();
		pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o2[0] == o1[0]) {
					return o1[1] - o2[1];
				}
				return o2[0] - o1[0];
			}
		});
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(i > 0 && i < N-1 && j > 0 && j < N-1 && map[i][j] != 0) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		size = list.size();
		v = new boolean[size];
		res = new int[size];
		res2 = new int[size];
//					for(int i = 0; i < list.size(); i++) {
//						System.out.println(Arrays.toString(list.get(i)));
//					}
		search();
		per(0);
		System.out.println("#" + tc + " " + pq.peek()[1]);
	}
}

static void search() {
	int dx[] = new int[] {-1,1,0,0};
	int dy[] = new int[] {0,0,-1,1};
	
	for(int i = 0; i < size; i++) {
		int[] temp = new int[5];
		int cnt = 0;
		int x = list.get(i)[0];
		int y = list.get(i)[1];
		for(int j = 0; j < 4; j++) {
			int nx = x + dx[j];
			int ny = y + dy[j];
			while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
//				System.out.println("a");
				if(map[nx][ny] == 1) {
					temp[j] = 1;
					cnt++;
					break;
				}
				nx = nx + dx[j];
				ny = ny + dy[j];
			}
		}
		if(cnt == 4) {
			list.remove(i);
			size = list.size();
			i--;
			continue;
		}
		search.add(temp);
	}
	size = list.size();
//	for(int i = 0; i < size; i++) {
//		System.out.println(Arrays.toString(search.get(i)));		
//	}
}

static void per(int cnt) { //방향을 담은 순열 생성 {3,3,3,3}
	if(cnt == size) {
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(res[i] == 4) {
				count++;
			}
			if(size - count < max) {
				return;
			}
		}
//		System.out.println(Arrays.toString(res));
		toDo();
		return;
	}

	for(int i = 0; i < 5; i++) {
		if(search.get(cnt)[i] == 1) {
			continue;
		}
		res[cnt] = i;
		per(cnt + 1);
		
	}
}

//static void per2(int cnt) { //방향을 담은 순열의 순서를 정하는 순열{3,2,1,4}
//	if(cnt == size){
//		System.out.println(++count);
//		System.out.println(Arrays.toString(res2));
//		toDo();
//		return;
//	}
//
//	for(int i = 0; i < size; i++) {
//		if(v[i]) {
//			continue;
//		}
//		v[i] = true;
//		res2[cnt] = i;
//		per2(cnt + 1);
//		v[i] = false;
//	}
//}

static void toDo() { //방향과 순서가 정해졌다면 시뮬레이션 시작
	int tmpmap[][] = new int[N][N];
	for(int i = 0; i < N; i++) {
		tmpmap[i] = Arrays.copyOf(map[i], N);
	}
	//		System.out.println();
	int dx[] = new int[] {-1,1,0,0,0};
	int dy[] = new int[] {0,0,-1,1,0};
	int result = 0;
	int cnt2 = 0;//연결된 코어의 숫자를 저장
	for(int i = 0; i < size; i++) {//순서대로 코어의 위치를 꺼내온다
		int cnt = 0;//코어마다 연결된 전선의 길이를 저장
		if(res[i] == 4) {
			continue;
		}
		int x = list.get(i)[0];
		int y = list.get(i)[1];
		int nx = x + dx[res[i]];
		int ny = y + dy[res[i]];
		while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
			if(tmpmap[nx][ny] == 1 || tmpmap[nx][ny] == 2) {
				cnt = 0;
				clean(nx , ny, tmpmap, res[i]);
				break;
			}
			tmpmap[nx][ny] = 2;
			cnt++;
			nx = nx + dx[res[i]];
			ny = ny + dy[res[i]];
		}
		if(cnt != 0) {
			cnt2++;
		}
		result += cnt;

	}
	pq.offer(new int[] {cnt2, result});
	if(!pq.isEmpty()) {
		if(max < pq.peek()[0]) {
			max = pq.peek()[0];
		}
	}
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(tmpmap[i]));
//			}
//			System.out.println();

//	System.out.println(result);
}

static void clean(int x, int y, int[][] tmpmap, int i) {
	int dxdy[] = new int[] {1,0,3,2};
	int dx[] = new int[] {-1,1,0,0,0};
	int dy[] = new int[] {0,0,-1,1,0};
	int nx = x + dx[dxdy[i]];
	int ny = y + dy[dxdy[i]];
	while(tmpmap[nx][ny] != 1) {
		tmpmap[nx][ny] = 0;
		nx = nx + dx[dxdy[i]];
		ny = ny + dy[dxdy[i]];
	}
}
}
