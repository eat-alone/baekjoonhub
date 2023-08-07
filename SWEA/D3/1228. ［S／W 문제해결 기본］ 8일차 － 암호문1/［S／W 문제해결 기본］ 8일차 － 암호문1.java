import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution {


	public static void main(String[] args) throws NumberFormatException, IOException {
		// 0~999999사이의 수가 나열 됨
		// insert mothod(x, y, s)
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(bf.readLine());

			if(N > 10) {
				N = 10;
			}

			int []arr = new int[10];

			st = new StringTokenizer(bf.readLine());

			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			N = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine(), "I ");
			for(int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int ins[] = new int[arr.length + num];
				for(int j = 0; j < x; j++) {
					if(j >= arr.length) {
						continue;
					}else {
						ins[j] = arr[j];
					}
				}
				for(int j = x; j < x + num; j++) {
					if(j >= 10) {
						st.nextToken();
						continue;
					}else {
						ins[j] = Integer.parseInt(st.nextToken());
					}
				}
				for(int j = x + num; j < arr.length; j++) {
					ins[j] = arr[j - num];
				}
				arr = Arrays.copyOf(ins, 10);
//				System.out.println(Arrays.toString(arr));
			}
			System.out.print("#" + tc + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}
