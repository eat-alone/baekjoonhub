import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<String> list = new ArrayList<String>();//후보 문자열 저장 리스트
	static boolean[] v; //조합을 위한 방문 추가
	static StringBuilder sb = new StringBuilder();
	static String[] mo = new String[] {"a", "e", "i", "o", "u"};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		v = new boolean[M];
		String[] temp = bf.readLine().split(" ");
		for(int i = 0; i < M; i++) {
			list.add(temp[i]);
		}
		
		Collections.sort(list);
		
		toDo(0,0);
	}
	static void toDo(int cnt, int start) {
		if(cnt == N) {
			String temp = "";
			int f = 0;
			for(int i = 0; i < M; i++) {
				if(v[i]) {
					temp += list.get(i);
				}
			}
			for(int i = 0; i < 5; i++) {
				if(temp.contains(mo[i])) {
					f++;
				}
			}
			if(f != 0 && temp.length() - f >= 2) {
				System.out.println(temp);
			}
			return;
		}
		
		for(int i = start; i < M; i++) {
			if(v[i]) {
				continue;
			}
			v[i] = true;
			toDo(cnt + 1, i + 1);
			v[i] = false;
		}
	}
}
