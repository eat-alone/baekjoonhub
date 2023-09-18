import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int arr[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		Arrays.sort(arr);
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				list.add(arr[i] + arr[j]);
			}
		}
		
		Collections.sort(list);
		int size = list.size();
		for(int i = N - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				if(bs(list, size, arr[i] - arr[j])) {
					System.out.println(arr[i]);
					return;
				}
			}
		}
	}
	static boolean bs(List<Integer> list, int size, int key) {
		int ep = size - 1;
		int sp = 0;
		while(sp <= ep) {
			int mid = (sp + ep) / 2;
			if(list.get(mid) == key) {
				return true;
			}
			
			if(list.get(mid) > key) {
				ep = mid - 1;
			}else if(list.get(mid) < key) {
				sp = mid + 1;
			}
		}
		return false;
	}
}
