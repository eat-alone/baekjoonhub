import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			Queue<Integer> q = new ArrayDeque<>();
			int n = sc.nextInt();
			int[] arr = new int[8];
			for(int i = 0; i < 8; i++) {
				arr[i] = sc.nextInt();
				q.offer(arr[i]);
			}

			int idx = 1;
			while(true) {
				if(idx == 6) {
					idx = 1;
				}
				if(q.peek() - idx <= 0) {
					q.poll();
					q.offer(0);
					break;
				}else {
					q.offer(q.poll() - idx);
				}
				idx++;
			}
			
			for(int i = 0; i < 8; i++) {
				arr[i] = q.poll();
			}
			
			System.out.print("#"+tc+" ");
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
