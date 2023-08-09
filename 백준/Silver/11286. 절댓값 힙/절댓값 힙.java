import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<int[]> qu = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[1] == b[1]) {
					return a[0] - b[0];
				}
				return a[1] - b[1];
			}
		});
		int N = Integer.parseInt(bf.readLine());

		for(int i = 0; i < N; i++) {
			int next = Integer.parseInt(bf.readLine());
			int absnext = Math.abs(next);
			if(next == 0) {
				if(!qu.isEmpty()) {
					sb.append(qu.poll()[0]).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else {
				qu.offer(new int[] {next, absnext});
			}
		}
		System.out.println(sb.toString());
	}
}
