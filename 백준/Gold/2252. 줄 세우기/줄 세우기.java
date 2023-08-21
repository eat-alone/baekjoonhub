import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> list2[];
	static int N,M,arr[];
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q = new ArrayDeque<Integer>();
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list2 = new ArrayList[N+1];
		arr = new int[N+1];

		for(int i = 1; i <= N; i++) {
			list2[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			int temp[] = new int[2];
			st = new StringTokenizer(bf.readLine());
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			list2[temp[0]].add(temp[1]);
			arr[temp[1]]++;
		}

		toDo();
		System.out.println(sb.toString());
	}
	static void toDo() {
		for(int i = 1; i <= N; i++) {
			if(arr[i] == 0) {
				arr[i]--;
				q.offer(i);
			}
		}
		while(!q.isEmpty()) {
			int size = q.size();
			int temp = q.poll();
			sb.append(temp).append(" ");
			for(int i = 0; i < list2[temp].size(); i++) {
				arr[list2[temp].get(i)]--;
				if(arr[list2[temp].get(i)] == 0) {
					q.offer(list2[temp].get(i));
				}
			}

		}
	}
}
