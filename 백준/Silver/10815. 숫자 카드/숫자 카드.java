import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int arr[] = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i < N; i++) {
			arr[i] = q.poll();
		}
		
		int R = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < R; i++) {
			sb.append(toDo(Integer.parseInt(st.nextToken()), arr.length - 1, 0, arr)).append(" ");
		}
		System.out.println(sb.toString());
	}
	static int toDo(int key, int top, int low, int[] arr) {
		int value = arr[(top + low)/2];
		if(low <= top) {
			if(key == value) {
				return 1;
			}else if(key > value) {
				return toDo(key, top, (top + low) / 2 + 1, arr);
			}else if(key < value){
				return toDo(key, (top + low) / 2 - 1, low, arr);
			}			
		}
		return 0;
	}
}
