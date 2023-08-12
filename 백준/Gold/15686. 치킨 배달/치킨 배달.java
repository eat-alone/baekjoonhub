import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<int[]> chlist;
	static List<int[]> hlist;
	static int N, M;
	static int MIN = Integer.MAX_VALUE;
	static int v;
	public static void main(String[] args) throws IOException {
		// 치킨집에서 각 집까지의 거리를 모두 더한 값을 정렬 아래서부터 M개 선택
//		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		chlist = new ArrayList<int[]>();
		hlist = new ArrayList<int[]>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					hlist.add(new int[] {i,j});
				}else if(temp == 2) {
					chlist.add(new int[] {i,j});
				}
			}
		}
		toDo(0, 0);
		System.out.println(MIN);
	}
	
	static void toDo(int cnt, int start) {
		if(cnt == M) {
			if(v == 0) return;
			int a = calc();
			if(MIN > a) {
				MIN = a;
			}
			return;
		}
		for(int i = start; i < chlist.size(); i++) {
			v |= (1 << i);
			toDo(cnt + 1, i + 1);
			v &= ~(1 << i);			
		}
	}
	
	static int calc() {
		int sum = 0;
		for(int i = 0; i < hlist.size(); i++) {
			int temp = Integer.MAX_VALUE;
			for(int j = 0; j < chlist.size(); j++) {
				if((v & (1 << j)) == (1 << j)) {
					int length = Math.abs(chlist.get(j)[0] - hlist.get(i)[0]) + Math.abs(chlist.get(j)[1] - hlist.get(i)[1]);
					if(temp > length) {
						temp = length;
					}
				}
			}
			sum += temp;
		}
		return sum;
	}
}
