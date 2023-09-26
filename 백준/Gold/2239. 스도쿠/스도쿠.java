import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int map[][] = new int[9][9];
	static ArrayList<int[]> list = new ArrayList<>();
	static int size;
	static boolean isEnd;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			String temp[] = bf.readLine().split("");
			for(int j = 0; j < 9; j++) {
				int tmp = Integer.parseInt(temp[j]);
				map[i][j] = tmp;
				if(tmp == 0) {
					list.add(new int[] {i,j});
				}
			}
		}
		size = list.size();
		toDo(0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	static void toDo(int idx) {
		if(idx == size) {
			isEnd = true;
			return;
		}
		
		int x = list.get(idx)[0];
		int y = list.get(idx)[1];
		
		for(int i = 1; i <= 9; i++) {
			map[x][y] = i;
			
			if(check1(x,y) && check2(x, y) && check3(x, y)) {
				toDo(idx + 1);
			}
			if(isEnd) {
				return;
			}
			map[x][y] = 0;
		}
	}
	
	static boolean check1(int x, int y) {
		int nx = (x / 3) * 3;
		int ny = (y / 3) * 3;
		for(int j = 0; j < 3; j++) {
			for(int k = 0; k < 3; k++){
				if(nx + j != x && ny + k != y) {
					if(map[nx+j][ny+k] == map[x][y]) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	static boolean check2(int x, int y) {
		for(int j = 0; j < 9; j++) {
			if(x != j) {
				if(map[j][y] == map[x][y]) {
					return false;
				}
			}
		}
		return true;
	}
	
	static boolean check3(int x, int y) {
		for(int j = 0; j < 9; j++) {
			if(y != j) {
				if(map[x][j] == map[x][y]) {
					return false;
				}
			}
		}
		return true;
	}
}
