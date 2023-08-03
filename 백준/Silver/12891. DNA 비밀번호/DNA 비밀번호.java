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
		
		int cnt = 0;
		for(int i = 0; i < orizinLen; i++) {
			if(orizinSet.charAt(i) == 'A') {
				count[0]--;
			}else if(orizinSet.charAt(i) == 'C') {
				count[1]--;
			}else if(orizinSet.charAt(i) == 'G') {
				count[2]--;
			}else if(orizinSet.charAt(i) == 'T') {
				count[3]--;
			}
			if(i + 1 >= partLen) {
				for(int j = 0; j < 4; j++) {
					if(count[j] > 0) {
						cnt = 0;
						break;
					}else {
						cnt++;
					}
				}
				if(cnt == 4) {
					res++;
					cnt = 0;
				}
				if(orizinSet.charAt(i - (partLen - 1)) == 'A') {
					count[0]++;
				}else if(orizinSet.charAt(i - (partLen - 1)) == 'C') {
					count[1]++;
				}else if(orizinSet.charAt(i - (partLen - 1)) == 'G') {
					count[2]++;
				}else if(orizinSet.charAt(i - (partLen - 1)) == 'T') {
					count[3]++;
				}
			}
		}
	
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
	}

}
