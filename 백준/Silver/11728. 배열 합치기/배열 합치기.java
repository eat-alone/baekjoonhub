import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arrA[] = new int[N];
		int arrB[] = new int[M];
		int arrC[] = new int[N+M];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < M; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = N+M;
		int aidx = 0;
		int bidx = 0;
		for(int i = 0; i < size; i++) {
			if(aidx < N && bidx < M) {
				if(arrA[aidx] > arrB[bidx]) {
					arrC[i] = arrB[bidx];
					bidx++;
				}else {
					arrC[i] = arrA[aidx];
					aidx++;
				}
			}else if(aidx >= N) {
				arrC[i] = arrB[bidx];
				bidx++;
			}else if(bidx >= M) {
				arrC[i] = arrA[aidx];
				aidx++;
			}
			sb.append(arrC[i]).append(" ");
		}
		System.out.println(sb);
	}

}
