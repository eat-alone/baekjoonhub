import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.omg.CORBA.INTERNAL;

public class Solution {
	static int N,SUM;
	static LinkedList<Integer> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {//2 62 62 6
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			SUM = 0;
			N = Integer.parseInt(bf.readLine());
			list = new LinkedList[5];
			
			StringTokenizer st;
			for(int i = 1; i <= 4; i++) {
				list[i] = new LinkedList<>();
				st = new StringTokenizer(bf.readLine());
				for(int j = 0; j < 8; j++) {
					list[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				int n = Integer.parseInt(st.nextToken());
				int o = Integer.parseInt(st.nextToken());
				toDo(n,o);
			}
			for(int i = 1; i <= 4; i++) {
				if(list[i].get(0) == 1) {
					SUM += (1 << (i - 1));
				}
			}
			System.out.println("#" + tc + " " + SUM);
		}
	}
	
	static void toDo(int n , int o) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[5];
		int[] v2 = new int[5];
		q.offer(n);
		v[n] = true;
		v2[n] = o;
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(temp + 1 <= 4) {
				if(!v[temp+1] && list[temp+1].get(6) != list[temp].get(2)) {
					q.offer(temp+1);
					v[temp + 1] = true;
					v2[temp + 1] = v2[temp] * -1;
				}
			}
			if(temp - 1 > 0) {
				if(!v[temp - 1] && list[temp-1].get(2) != list[temp].get(6)) {
					q.offer(temp-1);
					v[temp - 1] = true;
					v2[temp - 1] = v2[temp] * -1;
				}
			}
		}
		toDo2(v, v2);
	}
	
	static void toDo2(boolean[] v, int[] v2){
		for(int i = 1; i <= 4; i++) {
			if(v[i]) {
				if(v2[i]>0) {
					list[i].offerFirst(list[i].pollLast());
				}else if(v2[i]<0) {
					list[i].offerLast(list[i].pollFirst());					
				}
			}
		}
	}
}
