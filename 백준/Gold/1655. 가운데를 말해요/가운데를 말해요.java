import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static Queue<Integer> minQ = new PriorityQueue<Integer>();
	static Queue<Integer> maxQ = new PriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}
	
	});
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < n; i++) {
			int temp = Integer.parseInt(bf.readLine());
			if(maxQ.size() == minQ.size()) {
				maxQ.offer(temp);
				if(!minQ.isEmpty() && !maxQ.isEmpty()) {
					if(minQ.peek() < maxQ.peek()) {
						minQ.offer(maxQ.poll());
						maxQ.offer(minQ.poll());
					}					
				}
			}else {
				minQ.offer(temp);
				if(!minQ.isEmpty() && !maxQ.isEmpty()) {
					if(minQ.peek() < maxQ.peek()) {
						minQ.offer(maxQ.poll());
						maxQ.offer(minQ.poll());
					}					
				}
			}
			
			sb.append(String.valueOf(maxQ.peek())).append("\n");
		}
		
		System.out.println(sb);
	}

}
