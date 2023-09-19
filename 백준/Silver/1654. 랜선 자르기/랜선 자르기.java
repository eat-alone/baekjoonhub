import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long arr[] = new long[N];
		
		long ep = 0;
		for(int i = 0; i < K; i++) {
			long temp = Long.parseLong(bf.readLine());
			arr[i] = temp;
			if(temp > ep) {
				ep = temp;
			}
		}
		
		System.out.println(bs(arr, ep, N, K));
	}
	static long bs(long arr[], long ep, int N, int K) throws InterruptedException {
		long sp = 1;
		
		while(sp < ep ) {
			int cnt = 0;
			long mid = (sp + ep + 1) / 2;
			for(int i = 0; i < K; i++) {
				cnt += arr[i] / mid;
			}
			if(cnt >= N) {
				sp = mid;
			}else {
				ep = mid - 1;
			}
		}
		
		return sp;
	}
}
