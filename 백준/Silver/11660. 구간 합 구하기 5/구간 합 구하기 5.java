import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][n+1];
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j < n+1; j++) {
				map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < m; i++) {
			int res = 0;
			st = new StringTokenizer(bf.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j = x1; j <= x2; j++) {
				res = res + map[j][y2] - map[j][y1-1];
			}
			
			sb.append(res).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
