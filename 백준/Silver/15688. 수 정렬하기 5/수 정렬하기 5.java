import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		int arr[] = new int[2000002];
		int arr2[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			int temp = Integer.parseInt(bf.readLine()) + 1000000;
			arr[temp]++;
		}
		
		for(int i = 0; i <= 2000000; i++) {
			while(arr[i] > 0) {
				int a = i - 1000000;
				sb.append(a).append("\n");
				arr[i]--;
			}
		}
		
		System.out.println(sb);
	}
}
