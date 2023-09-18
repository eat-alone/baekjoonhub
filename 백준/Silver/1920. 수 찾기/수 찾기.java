import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
//		PriorityQueue<Integer> q = new PriorityQueue<>();


		int N = Integer.parseInt(bf.readLine());
		int arr[] = new int[N];

		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
//			q.offer(Integer.parseInt(st.nextToken()));
		}
//		for(int i = 0; i < N; i++) {
//			arr[i] = q.poll();
//		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < M; i++) {
			sb.append(bsearch(arr, Integer.parseInt(st.nextToken()), N)).append("\n");
		}

		System.out.println(sb);
	}

	private static int bsearch(int[] arr, int target, int N) {
		int ep = N - 1;
		int sp = 0;
		
		while(sp <= ep) {
			int mid = (ep + sp) / 2;
			if(arr[mid] == target) {
				return 1;
			}
			if(arr[mid] < target) {
				sp = mid + 1;
			}else if(arr[mid] > target) {
				ep = mid - 1;
			}
		}
		return 0;
	}
}
