import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, P[][], max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		P = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			P[i][0] = w;
			P[i][1] = v;
		}
		
		int[] dp = new int[K+1];
		
		for(int i = 0; i < N; i++) {
			for(int j = K; j-P[i][0] >= 0; j--) {
				dp[j] = Math.max(dp[j], dp[j - P[i][0]] + P[i][1]);
			}
		}
		
		System.out.println(dp[K]);
		//N개의 물건을 K가 넘지 않는 선에서 조합할 수 있을 만큼 부분집합 생성
		//담은 물건들의 가치 총합을 비교
//		toDo(0, 0, 0);
//		
//		System.out.println(max);
	}
	
//	private static void toDo(int w, int v, int start) {
//		//종료조건
//		if(w > K) { //담은 물건들의 무게가 배당에 안들어가면 리턴
//			return;
//		}
//		
//		if(v > max) {//담은 물건들의 가치가 최댓값이라면 갱신			
//			max = v;			
//		}
//		
//		for(int i = start; i < N; i++) {
//			toDo(w + P[i][0], v + P[i][1], start + 1);
//		}
//	}
}
