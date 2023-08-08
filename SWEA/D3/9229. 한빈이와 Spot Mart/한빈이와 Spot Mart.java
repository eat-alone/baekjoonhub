import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			st = new StringTokenizer(bf.readLine());
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;                        //가장 무거운 경우를 담을 변수
			
			for(int i = 0; i < n; i++) {        //과자 n봉지 중에서 두봉지를 뽑는 경우의 수
				for(int j = i+1; j < n; j++) {
					if(arr[i] + arr[j] > m) {   //제한 무게보다 무거우면 다음 경우의 수 확인
						continue;
					}else {
						if(arr[i] + arr[j] >= max) { //가장 무거운 조합 찾기
							max = arr[i] + arr[j];
						}
					}
				}
			}
			
			if(max == 0) System.out.println("#" + tc + " " + -1);
			else System.out.println("#" + tc + " " + max);
		}
	}

}
