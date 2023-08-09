import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int map[][] = new int[100][100];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(bf.readLine());
		int sum = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			for(int j = n; j < n + 10; j++) {
				for(int k = m; k < m + 10; k++) {
					if(map[j][k] == 1) {
						continue;
					}else {
						map[j][k] = 1;
						sum++;
					}
				}
			}
		}
		System.out.println(sum);
	}

}
