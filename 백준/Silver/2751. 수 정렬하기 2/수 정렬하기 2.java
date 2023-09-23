import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	static int arr[];
	static int temp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		temp = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		toDo(0,N);
		for(int i = 0; i < N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void toDo(int sp, int ep)   {
		if(ep <= sp + 1) {
			return;
		}
		int mid = (sp + ep) / 2;
		toDo(sp, mid);
		toDo(mid, ep);
		merge(sp, ep);
	}

	private static void merge(int sp, int ep) {
		int mid = (sp + ep) / 2;
		int lidx = sp;
		int ridx = mid;
		
		for(int i = sp; i < ep; i++) {
			if(lidx < mid && ridx < ep) {
				if(arr[lidx] > arr[ridx]) {
					temp[i] = arr[ridx];
					ridx++;
				}else {
					temp[i] = arr[lidx];
					lidx++;
				}
			}else if(lidx >= mid) {
				temp[i] = arr[ridx];
				ridx++;
			}else if(ridx >= ep) {
				temp[i] = arr[lidx];
				lidx++;
			}
		}
		for(int i = sp; i < ep; i++) {
			arr[i] = temp[i];
		}
	}
}
