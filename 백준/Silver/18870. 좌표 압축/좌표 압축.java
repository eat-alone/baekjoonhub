import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		
		int N = Integer.parseInt(bf.readLine());
		int arr[] = new int[N];
		List<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
			if(map.get(temp) == null) {
				map.put(temp, 0);
				list.add(temp);
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		
		Collections.sort(list);
//		System.out.println(list);
		int size = list.size();
		for(int i = 0; i < N; i++) {
			sb.append(bsearch(list, size, arr[i])).append(" ");
		}
		System.out.println(sb);
	}
	static int bsearch(List<Integer> list, int size, int key) {
		int ep = size - 1;
		int sp = 0;
		
		while(sp <= ep) {
			int mid = (ep + sp) / 2;
			
			if(list.get(mid) == key) {
				return mid;
			}
			if(list.get(mid) > key) {
				ep = mid - 1;
			}else if(list.get(mid) < key) {
				sp = mid + 1;
			}
		}
		
		return 0;
	}
}
