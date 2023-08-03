import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int a = 0;//0000 0000 0000 0000 0000
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			String s;
			int num = 0;
			if(st.countTokens() == 1) {
				s = st.nextToken();
			}else {
				s = st.nextToken();
				num = Integer.parseInt(st.nextToken());
			}
			
			switch (s) {
			case "add":
				add(num);
				break;
			case "remove":
				remove(num);
				break;
			case "check":
				check(num);
				break;
			case "toggle":
				toggle(num);
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	static void add(int n) {
		a = a | 1<<(n - 1); //0000 0000 0000 0000 0001
		//1111 1111 1111 1111 1111

	}
	static void remove(int n) {
		if(((a & 1<<(n-1)) != 0)){
			a = a ^ 1<<(n-1);
		}
	}
	static void check(int n) {
		if(((a & 1<<(n-1)) != 0)){
			sb.append("1").append("\n");
		}else {
			sb.append("0").append("\n");
		}
	}
	static void toggle(int n) {
		a = a ^ 1<<(n-1);
	}
	static void all() {
		a = a | ((1<<21) -1);
	}
	static void empty() {
		a = 0;
	}
}
