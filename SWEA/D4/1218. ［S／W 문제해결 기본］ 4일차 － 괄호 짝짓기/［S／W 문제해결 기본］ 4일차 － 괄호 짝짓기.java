import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			Stack<Character> s = new Stack<>();
			int num = sc.nextInt();
			String s1 = sc.next();
			for(int i = 0; i < num; i++) {
				if(!s.isEmpty() && (int)s.peek() + 1 == (int)s1.charAt(i)) {
					s.pop();
				}else if(!s.isEmpty() && (int)s.peek() + 2 == (int)s1.charAt(i)){
					s.pop();
				}else {
					s.push(s1.charAt(i));
				}
			}
			if(s.isEmpty()) {
				System.out.println("#"+tc+" " + 1);
			}else {
				System.out.println("#"+tc+" " + 0);
			}
		}
		
	}

}
