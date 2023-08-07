import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		int[] res = new int[N];
		for(int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		int idx = 0;
		int idx2 = 0;
		sb.append("<");
		while(idx2 < N) {
			for(int i = 0; i < K; i++) {
				idx++;
				if(idx > N) {
					idx = 1;
				}
				if(arr[idx] == -1) {
					i--;
				}
			}
			sb.append(arr[idx]).append(", ");
			arr[idx] = -1;
			idx2++;
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
	}

}
