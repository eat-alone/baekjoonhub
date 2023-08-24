import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		int[] v = new int[d+1];
		int[] arr = new int[N];
		int cnt = 0;
		int size = N + k;
		for(int i = 0; i < size; i++) {
//			System.out.println(Arrays.toString(v) + " " + cnt);
			if(i < N) {
				int temp = Integer.parseInt(bf.readLine());
				arr[i] = temp;
				if(i>=k) {
					if(cnt == k && v[c] == 0) {
						System.out.println(k+1);
						return;
					}else if(cnt <= k && v[c] >= 1) {
						cnt = cnt;
						if(max < cnt) {
							max = cnt;
						}
					}else if(cnt < k && v[c] == 0) {
						cnt++;
						if(max < cnt) {
							max = cnt;
						}
						cnt--;
					}
					v[temp]++;
					if(v[temp] == 1 ) {
						cnt++;
					}
					v[arr[i-k]]--;
					if(v[arr[i - k]] == 0) {
						cnt--;
					}
				}else {
					if(v[temp]>0) {
						v[temp]++;
					}else {
						v[temp]++;
						cnt++;					
					}
				}
			}else {
				if(cnt == k && v[c] == 0) {
					System.out.println(k+1);
					return;
				}else if(cnt <= k && v[c] >= 1) {
					cnt = cnt;
					if(max < cnt) {
						max = cnt;
					}
				}else if(cnt < k && v[c] == 0) {
					cnt++;
					if(max < cnt) {
						max = cnt;
					}
					cnt--;
				}
				v[arr[i % N]]++;
				if(v[arr[i % N]] == 1 ) {
					cnt++;
				}
				v[arr[i-k]]--;
				if(v[arr[i - k]] == 0) {
					cnt--;
				}
			}
		}
//		if(cnt == k && v[c] == 0) {
//			System.out.println(k+1);
//			return;
//		}else if(cnt <= k && v[c] == 1) {
//			cnt = cnt;
//			if(max < cnt) {
//				max = cnt;
//			}
//		}else if(cnt < k && v[c] == 0) {
//			cnt++;
//			if(max < cnt) {
//				max = cnt;
//			}
//			cnt--;
//		}
//		System.out.println(Arrays.toString(arr));		
		System.out.println(max);			
	}

}
