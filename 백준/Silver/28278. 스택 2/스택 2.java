import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		ArrayList list = new ArrayList();
		int n = Integer.parseInt(bf.readLine()); //Int
		for(int i = 0; i < n; i++) {
			String s = bf.readLine(); //String
			String s1;
			String array[] = s.split(" ");
			switch(array[0]) {
			case "1":
				list.add(array[1]);
				//				System.out.println("case1 : 리스트 add / 들어간 값 : " + array[1]);
				break;
			case "2":
				//				System.out.println(list.get(list.size()-1));
				if(list.size() == 0) {
					s1 = String.valueOf("-1");//출력할 문자열
					//					System.out.println("case2 : pull / 나온 값 : " + s1);
					bw.write(s1);//출력
					bw.newLine(); //줄바꿈
				}else {
					s1 = String.valueOf(list.get(list.size() - 1));//출력할 문자열
					//					System.out.println("case2 : pull / 나온 값 : " + s1);
					bw.write(s1);//출력
					bw.newLine(); //줄바꿈
					list.remove(list.size() - 1);
				}
				break;
			case "3":
				s1 = String.valueOf(list.size());//출력할 문자열
				//				System.out.println("case3 : 스택 사이즈 / 나온 값 : " + s1);
				bw.write(s1);//출력
				bw.newLine(); //줄바꿈
				break;
			case "4":
				if(list.size() == 0) {
					//					System.out.println(1);
					s1 = String.valueOf("1");//출력할 문자열
					bw.write(s1);//출력
					bw.newLine(); //줄바꿈
				}else {
					s1 = String.valueOf("0");//출력할 문자열
					bw.write(s1);//출력
					bw.newLine(); //줄바꿈
				}
				break;
			case "5":
				if(list.size() == 0) {
					//					System.out.println(1);
					s1 = String.valueOf("-1");//출력할 문자열
					bw.write(s1);//출력
					bw.newLine(); //줄바꿈
				}else {
					s1 = String.valueOf(list.get(list.size()-1));//출력할 문자열
					bw.write(s1);//출력
					bw.newLine(); //줄바꿈
				}
				break;
			default :
				break;
			}
		}
		bw.flush();
		bw.close();//스트림을 닫음
	}
}
