import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int H,W;
	static String[][] map;
	static int[] now;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new String[H][W];
			now = new int[2];
			for(int i = 0; i < H; i++) {
				map[i] = bf.readLine().split("");
				for(int j = 0; j < W; j++) {
					if(map[i][j].equals("<")) {//"<", "^", "v" ,">"
						now[0] = i;
						now[1] = j;
					}else if(map[i][j].equals("^")) {
						now[0] = i;
						now[1] = j;						
					}else if(map[i][j].equals("v")) {
						now[0] = i;
						now[1] = j;						
					}else if(map[i][j].equals(">")) {
						now[0] = i;
						now[1] = j;						
					}
				}
			}
			
			int N = Integer.parseInt(bf.readLine());
			String[] d = bf.readLine().split("");
			for(int i = 0; i < N; i++) {
				toDo(d[i]);
			}
			
			System.out.print("#"+ tc + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	static void toDo(String a) {
		if(a.equals("S") && canShoot()) {
			return;
		}else if(a.equals("U") && canMove(a)) {
			return;
		}else if(a.equals("D") && canMove(a)) {
			return;
		}else if(a.equals("L") && canMove(a)) {
			return;
		}else if(a.equals("R") && canMove(a)) {
			return;
		}
	}
	
	static boolean canShoot() {
		int x = now[0];
		int y = now[1];
		if(map[x][y].equals("<")) {
			for(int i = y - 1; i >= 0; i--) {
				if(map[x][i].equals("*")) {
					map[x][i] = ".";
					return true;
				}else if(map[x][i].equals("#")) {
					return true;
				}
			}
		}else if(map[x][y].equals("^")) {
			for(int i = x - 1; i >= 0; i--) {
				if(map[i][y].equals("*")) {
					map[i][y] = ".";
					return true;
				}else if(map[i][y].equals("#")) {
					return true;
				}
			}
		}else if(map[x][y].equals(">")) {
			for(int i = y + 1; i < W; i++) {
				if(map[x][i].equals("*")) {
					map[x][i] = ".";
					return true;
				}else if(map[x][i].equals("#")) {
					return true;
				}
			}
		}else if(map[x][y].equals("v")) {
			for(int i = x + 1; i < H; i++) {
				if(map[i][y].equals("*")) {
					map[i][y] = ".";
					return true;
				}else if(map[i][y].equals("#")) {
					return true;
				}
			}
		}
		return true;
	}
	
	static boolean canMove(String a) {
		int x = now[0];
		int y = now[1];
		if(a.equals("U")) {
			map[x][y] = "^";
			if(x - 1 >= 0 && map[x-1][y].equals(".")) {
				map[x][y] = ".";
				map[x-1][y] = "^";
				now[0] = x - 1;
			}
		}else if(a.equals("D")) {
			map[x][y] = "v";
			if(x + 1 < H && map[x+1][y].equals(".")) {
				map[x][y] = ".";
				map[x+1][y] = "v";
				now[0] = x + 1;
			}
		}else if(a.equals("L")) {
			map[x][y] = "<";
			if(y - 1 >= 0 && map[x][y-1].equals(".")) {
				map[x][y] = ".";
				map[x][y-1] = "<";
				now[1] = y - 1;
			}
		}else if(a.equals("R")) {
			map[x][y] = ">";
			if(y + 1 < W && map[x][y+1].equals(".")) {
				map[x][y] = ".";
				map[x][y+1] = ">";
				now[1] = y + 1;
			}
		}
		return true;
	}
}
