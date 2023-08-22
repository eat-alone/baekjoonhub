import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<String> list = new ArrayList<String>();//후보 문자열 저장 리스트
	static boolean[] v; //조합을 위한 방문 추가
	static String[] mo = new String[] {"a", "e", "i", "o", "u"}; //모음 포함되어있는가 비교하기 위한 배열
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
		
		Collections.sort(list); // 오름차순 정렬
		
		toDo(0,0); //DFS 시작
	}
	static void toDo(int cnt, int start) {
		if(cnt == N) {       //N개 뽑기
			String temp = ""; //임시 스트링 변수
			int f = 0;        //자음 갯수 파악을 위한 변수
			for(int i = 0; i < M; i++) { //방문체크 배열을 통해
				if(v[i]) {
					temp += list.get(i); //임시 스트링 변수 생성
				}
			}
			for(int i = 0; i < 5; i++) {  //모음이 포함되어 있는지 비교
				if(temp.contains(mo[i])) { //포함되어있따면 모음 갯수 세기
					f++;
				}
			}
			if(f != 0 && temp.length() - f >= 2) { //모음이 포함 되어있고 스트링 변수에 남은 자음 개수가 두개 이상이어야
				System.out.println(temp);          //출력한다
			}
			return;
		}
		
		for(int i = start; i < M; i++) {  //조합 생성
//			if(v[i]) {                    //이전에 뽑았다면
//				continue;                 //다음으로 건너 뛰기
//			}
			v[i] = true;                  //뽑았으면 방문 체크
			toDo(cnt + 1, i + 1);         //다음 뽑기 진행
			v[i] = false;                 //방문 체크 해제
		}
	}
}
