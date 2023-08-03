import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int map[][] = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int res = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int temp = 0;
					a:for(int k = 0; k < M; k++) {
						for(int l = 0; l < M; l++) {
							if(i+k >= N || j+l >= N) {
								temp = 0;
								break a;
							}
							temp += map[i+k][j+l];
						}
					}
					if(temp > res) {
						res = temp;
					}
				}
			}
			
			System.out.println("#"+testCase+" "+res);
		}
	}

}
