import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		//if 과일 섭취 길이++
		//과일들의 높이 다름 자기 길이보다 작거나 같으면 먹을 수 있음
		PriorityQueue<Integer> q = new PriorityQueue<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < N; i++) {
			if(q.poll() <= L) {
				L++;
			}
		}
		System.out.println(L);
	}

}
