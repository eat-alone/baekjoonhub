import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(bf.readLine());
		
		for(int T = 1; T <= tc; T++) {
			int n = Integer.parseInt(bf.readLine());
			int[] p = new int[n];
			int[] dp = new int[n];
			st = new StringTokenizer(bf.readLine());
			for(int i = 0; i < n; i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			
			dp[0] = 1;
			int max = 0;
			for(int i = 1; i < n; i++) {
				dp[i] = 1;
				for(int j = 0; j < i; j++) {
					if(p[i] > p[j] && dp[j] >= dp[i]) {
						dp[i] = dp[j] + 1;
					}
					if(dp[i] > max) {
						max = dp[i];
					}
				}
			}
			
			System.out.println("#" + T + " " + max);
		}
	}

}
