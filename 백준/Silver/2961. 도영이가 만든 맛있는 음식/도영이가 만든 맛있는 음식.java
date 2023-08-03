import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, food[][];
	static int temp = 1000000000;
//	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//재료 N개
		//신맛 S, 쓴맛 B
		//신맞 = 곱연산, 쓴맛 = 합연산
		//재료를 조합한다 요리를 하게 되면 재료 1의 신맛과 재료 2의 신맛이 곱해진다.
		//						 재료 1의 쓴맛과 재료 2의 쓴맛은 더해진다.
		//						요리 완료 후 둘의 차이를 구한다. 가장 차이가 적은 수 반환
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		N = Integer.parseInt(bf.readLine());
		food = new int[N][2];
//		v = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}
		cook(0,1,0,0);
		System.out.println(temp);
	}
	static void cook(int cnt, int sumS, int sumB, int isSelect) {
		if(cnt == N) {
//			for(int i = 0; i < N; i++) {
//				if(v[i]) {
//					System.out.print((i+1) + " ");
//				}
//			}
//			System.out.println();
//			System.out.println(sumS + " " + sumB + " " + Math.abs(sumS-sumB));
			if(isSelect != 0 && Math.abs(sumS - sumB) <= temp) {
				temp = Math.abs(sumS - sumB);
			}
			return;
		}
		int temp1 = sumS;
		int temp2 = sumB;
		sumS = sumS * food[cnt][0];
		sumB = sumB + food[cnt][1];
//		v[cnt] = true;
		cook(cnt + 1, sumS ,sumB, isSelect + 1);
		sumS = temp1;
		sumB = temp2;
//		v[cnt] = false;
		cook(cnt + 1, sumS, sumB, isSelect);
	}
}
