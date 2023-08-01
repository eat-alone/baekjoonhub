import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//학생 N명
		//남학생 : 스위치번호가 받은 숫자의 배수이면 스위치 조작 if 3 -> 3 and 6 조작
		//여학생 : 스위치번호 기준 양옆으로 대칭일때만 대칭인 범위 까지 스위치 조작
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int arrSize = Integer.parseInt(bf.readLine());
		int[] swArr = new int[arrSize];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i = 0; i < arrSize; i++) {
			swArr[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(swArr));
		
		int stNum = Integer.parseInt(bf.readLine());
		ArrayList<int[]> stArr = new ArrayList<int[]>(stNum);
		int[] attribute;
		
		for(int i = 0; i < stNum; i++) {
			st = new StringTokenizer(bf.readLine());
			attribute = new int[2];
			for(int j = 0; j < 2; j++) {
				attribute[j] = Integer.parseInt(st.nextToken());
			}
			stArr.add(attribute);
		}
		
		
		
		for(int i = 0; i < stNum; i++) {
			if(stArr.get(i)[0] == 1) {
//				System.out.println("남학생");
				for(int j = 0; j < arrSize; j++) {
					if((j + 1) % stArr.get(i)[1] == 0) {
//						System.out.println(stArr.get(i)[1]);
						if(swArr[j] == 0) {
							swArr[j] = 1;
						}else {
							swArr[j] = 0;
						}
					}
				}
//				System.out.println(Arrays.toString(swArr));
			}else {
//				System.out.println(stArr.get(i)[1]);
				int x = stArr.get(i)[1] - 1;
//				System.out.println(x);
				int dx = 0;
				for(int j = 1; j < arrSize / 2 + 1; j++) {
					if(x + j >= arrSize || x - j < 0) {
						dx = j - 1;
						break;
					}if(swArr[x+j] == swArr[x-j]) {
						dx = j;
					}else {
						dx = j - 1;
						break;
					}
				}
				for(int j = x - dx; j < x + dx + 1; j++) {
					if(swArr[j] == 0) {
						swArr[j] = 1;
					}else {
						swArr[j] = 0;
					}
				}
			}
		}
		for(int i = 0; i < arrSize; i++) {
			if(sb.length() == 40) {
				System.out.println(sb.toString());
				sb.setLength(0);
			}
			sb = sb.append(swArr[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
