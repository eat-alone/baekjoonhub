import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		combi(0, 1);
		bw.close();
	}
	static void combi(int cnt, int start) throws IOException {
		if(cnt >= M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			bw.write(sb.append("\n").toString());
			bw.flush();
			sb.setLength(0);
			return;
		}
		
		for(int i = start; i < N + 1; i++) {
			arr[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}
}
