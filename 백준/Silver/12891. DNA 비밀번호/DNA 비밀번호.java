import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int orizinLen, partLen;
	static String orizinSet;
	static int[] count = new int[4];
	static int res;
	public static void main(String[] args) throws IOException {
		//DNA = {‘A’, ‘C’, ‘G’, ‘T’}
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		orizinLen = Integer.parseInt(st.nextToken());
		partLen = Integer.parseInt(st.nextToken());
		orizinSet = bf.readLine();
		
		st = new StringTokenizer(bf.readLine());
		count[0] = Integer.parseInt(st.nextToken());
		count[1] = Integer.parseInt(st.nextToken());
		count[2] = Integer.parseInt(st.nextToken());
		count[3] = Integer.parseInt(st.nextToken());
		int[] temp = Arrays.copyOf(count, 4);
		
//		a:for(int i = 0; i < orizinLen; i++) {
//			temp = Arrays.copyOf(count, 4);
//			for(int j = 0; j < partLen; j++) {
//				if(i+partLen > orizinLen) {
//					break a;
//				}
//				if(orizinSet.charAt(i+j) == 'A') {
//					temp[0]--;
//				}else if(orizinSet.charAt(i+j) == 'C') {
//					temp[1]--;
//				}else if(orizinSet.charAt(i+j) == 'G') {
//					temp[2]--;
//				}else if(orizinSet.charAt(i+j) == 'T') {
//					temp[3]--;
//				}
//			}
//			for(int j = 0; j < 4; j++) {
//				if(temp[j] > 0) {
//					continue a;
//				}
//			}
//			res++;
//		}
		int count = 0;
		for(int i = 0; i < orizinLen; i++) {
			if(orizinSet.charAt(i) == 'A') {
				temp[0]--;
			}else if(orizinSet.charAt(i) == 'C') {
				temp[1]--;
			}else if(orizinSet.charAt(i) == 'G') {
				temp[2]--;
			}else if(orizinSet.charAt(i) == 'T') {
				temp[3]--;
			}
			if(i + 1 >= partLen) {
				for(int j = 0; j < 4; j++) {
					if(temp[j] > 0) {
						count = 0;
						break;
					}else {
						count++;
					}
				}
				if(count == 4) {
					res++;
					count = 0;
				}
				if(orizinSet.charAt(i - (partLen - 1)) == 'A') {
					temp[0]++;
				}else if(orizinSet.charAt(i - (partLen - 1)) == 'C') {
					temp[1]++;
				}else if(orizinSet.charAt(i - (partLen - 1)) == 'G') {
					temp[2]++;
				}else if(orizinSet.charAt(i - (partLen - 1)) == 'T') {
					temp[3]++;
				}
			}
		}
	
		System.out.println(res);
	}

}
