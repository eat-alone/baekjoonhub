import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Data> qu = new PriorityQueue<Data>();
		int N = Integer.parseInt(bf.readLine());

		for(int i = 0; i < N; i++) {
			int next = Integer.parseInt(bf.readLine());
			if(next == 0) {
				if(!qu.isEmpty()) {
					System.out.println(qu.poll().getRealnum());
				}else {
					System.out.println(0);
				}
			}else {
				qu.offer(new Data(next, Math.abs(next)));
			}

		}
	}

	static class Data implements Comparable<Data>{
		int realnum;
		int sqrnum;

		Data(int real, int sqrt){
			this.realnum = real;
			this.sqrnum = sqrt;
		}

		public int getRealnum() {
			return realnum;
		}

		@Override
		public int compareTo(Data o) {
			if(this.sqrnum == o.sqrnum) {
				return this.realnum - o.realnum;
			}
			return this.sqrnum - o.sqrnum;
		}
	}
}

