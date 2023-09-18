import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(bf.readLine());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
			if(map.get(temp) == null) {
				map.put(temp, 1);
			}else {
				int v = map.get(temp);
				map.put(temp, v + 1);
			}
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < M; i++) {
			sb.append(bsearch(arr, Integer.parseInt(st.nextToken()), N, map)).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static int bsearch(int[] arr, int key, int N, HashMap<Integer, Integer> map) {
		int ep = N-1;
		int sp = 0;
		int cnt = 0;
		while(sp <= ep) {
			int mid = (sp + ep) / 2;
			
			if(arr[mid] == key) {
				cnt = map.get(arr[mid]);
				return cnt;
			}
			
			if(arr[mid] < key) {
				sp = mid + 1;
			}else if(arr[mid] > key) {
				ep = mid - 1;
			}
		}
		
		return 0;
	}
}
