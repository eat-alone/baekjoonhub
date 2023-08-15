import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int white, blue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		toDo(map, N, 0, 0, N, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void toDo(int[][] map, int n, int x, int y, int x2, int y2) {
		int[][] temp = new int[n][n];
		int sum = 0;
		int size = n * n;
		
		for(int i = 0; i < n; i++) {
			temp[i] = Arrays.copyOfRange(map[x], y, y2);
			x++;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(temp[i][j] == 0) {
					sum++;
				}
			}
		}
		
		if(sum == size) {
			white++;
		}else if(sum == 0) {
			blue++;
		}else {
			toDo(temp, n/2, 0, 0, n/2, n/2);
			toDo(temp, n/2, 0, n/2, n/2, n);
			toDo(temp, n/2, n/2, 0, n, n/2);
			toDo(temp, n/2, n/2, n/2, n, n);
		}
	}
}
