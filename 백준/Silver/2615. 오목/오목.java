import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] game=new int[19][19];
	public static void main(String[] args) throws Exception {
		//////////////////////////////////////////////////////////////
		// 테스트 후 아래 파일 입력을 표준입력으로 처리하는 문장은 주석 처리해주세요!!!! ( System.setIn처리 코드 )
		//////////////////////////////////////////////////////////////
		//System.setIn(new FileInputStream("Test5.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] a;
		int winner = 0;
		int five = 0;
		int x = 0, y = 0;
		//a = br.readLine().split(" ");
//		System.out.println(Arrays.toString(a));
		int[][] board = new int[19][19];
		for(int i = 0; i < 19; i++) {
			a = br.readLine().split(" ");
			for(int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(a[j]);
			}
		}
		
		a: for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(board[i][j] == 0) {
					continue;
				}else if(board[i][j] == 1) {
					for(int k = 1; k < 6; k++) {
						if(i + k >= 19) {
							if(five == 4) {
								if(i - 1 < 0) {
									winner = 1;
									x = i + 1;
									y = j + 1;
									break a;
								}else {
									if(board[i-1][j] == 1) {
										five = 0;
										break;
									}else {
										winner = 1;
										x = i + 1;
										y = j + 1;
										break a;
									}
								}
							}
							five = 0;
							break;
						}else {
							if(board[i+k][j] == 1) {
								five++;
							}else {
								if(five == 4) {
									if(i - 1 < 0) {
										winner = 1;
										x = i + 1;
										y = j + 1;
										break a;
									}else {
										if(board[i-1][j] == 1) {
											five = 0;
											break;
										}else {
											winner = 1;
											x = i + 1;
											y = j + 1;
											break a;
										}
									}
								}else {
									five = 0;
									break;
								}
							}
						}
					}
					if(five == 5) {
						five = 0;
					}
					for(int k = 1; k < 6; k++) {
						if(j + k >= 19) {
							if(five == 4) {
								if(j - 1 < 0) {
									winner = 1;
									x = i + 1;
									y = j + 1;
									break a;
								}else {
									if(board[i][j-1] == 1) {
										five = 0;
										break;
									}else {
										winner = 1;
										x = i + 1;
										y = j + 1;
										break a;
									}
								}
							}
							five = 0;
							break;
						}else {
							if(board[i][j+k] == 1) {
								five++;
							}else {
								if(five == 4) {
									if(j - 1 < 0) {
										winner = 1;
										x = i + 1;
										y = j + 1;
										break a;
									}else {
										if(board[i][j-1] == 1) {
											five = 0;
											break;
										}else {
											winner = 1;
											x = i + 1;
											y = j + 1;
											break a;
										}
									}
								}else {
									five = 0;
									break;
								}
							}
						}
					}
					if(five == 5) {
						five = 0;
					}
					for(int k = 1; k < 6; k++) {
						if(i + k >= 19 || j + k >=19) { // (2,1) 1만남 탐색 시작
							if(five == 4) {
								if(i - 1 < 0 || j - 1 < 0) {
									winner = 1;
									x = i + 1;
									y = j + 1;
									break a;
								}else {
									if(board[i-1][j-1] == 1) {
										five = 0;
										break;
									}else {
										winner = 1;
										x = i + 1;
										y = j + 1;
										break a;
									}
								}
							}
							five = 0;
							break;
						}else {
							if(board[i+k][j+k] == 1) {
								five++;
							}else {
								if(five == 4) {
									if(i - 1 < 0 || j - 1 < 0) {
										winner = 1;
										x = i + 1;
										y = j + 1;
										break a;
									}else {
										if(board[i-1][j-1] == 1) {
											five = 0;
											break;
										}else {
											winner = 1;
											x = i + 1;
											y = j + 1;
											break a;
										}
									}
								}else {
									five = 0;
									break;
								}
							}
						}
					}
					if(five == 5) {
						five = 0;
					}
					for(int k = 1; k < 6; k++) {
						if(i - k < 0 || j + k >=19) {
							if(five == 4) {
								if(i + 1 >= 19 || j - 1 < 0) {
									winner = 1;
									x = i + 1;
									y = j + 1;
									break a;
								}else {
									if(board[i+1][j-1] == 1) {
										five = 0;
										break;
									}else {
										winner = 1;
										x = i + 1;
										y = j + 1;
										break a;
									}
								}
							}
							five = 0;
							break;
						}else {
							if(board[i-k][j+k] == 1) {
								five++;
							}else {
								if(five == 4) {
									if(i + 1 >= 19 || j - 1 < 0) {
										winner = 1;
										x = i + 1;
										y = j + 1;
										break a;
									}else {
										if(board[i+1][j-1] == 1) {
											five = 0;
											break;
										}else {
											winner = 1;
											x = i + 1;
											y = j + 1;
											break a;
										}
									}
								}else {
									five = 0;
									break;
								}
							}
						}
					}
					if(five == 5) {
						five = 0;
					}
				}else {
					for(int k = 1; k < 6; k++) {
						if(i + k >= 19) {
							if(five == 4) {
								if(i - 1 < 0) {
									winner = 2;
									x = i + 1;
									y = j + 1;
									break a;
								}else {
									if(board[i-1][j] == 2) {
										five = 0;
										break;
									}else {
										winner = 2;
										x = i + 1;
										y = j + 1;
										break a;
									}
								}
							}
							five = 0;
							break;
						}else {
							if(board[i+k][j] == 2) {
								five++;
							}else {
								if(five == 4) {
									if(i - 1 < 0) {
										winner = 2;
										x = i + 1;
										y = j + 1;
										break a;
									}else {
										if(board[i-1][j] == 2) {
											five = 0;
											break;
										}else {
											winner = 2;
											x = i + 1;
											y = j + 1;
											break a;
										}
									}
								}else {
									five = 0;
									break;
								}
							}
						}
					}
					if(five == 5) {
						five = 0;
					}
					for(int k = 1; k < 6; k++) {
						if(j + k >= 19) {
							if(five == 4) {
								if(j - 1 < 0) {
									winner = 2;
									x = i + 1;
									y = j + 1;
									break a;
								}else {
									if(board[i][j-1] == 2) {
										five = 0;
										break;
									}else {
										winner = 2;
										x = i + 1;
										y = j + 1;
										break a;
									}
								}
							}
							five = 0;
							break;
						}else {
							if(board[i][j+k] == 2) {
								five++;
							}else {
								if(five == 4) {
									if(j - 1 < 0) {
										winner = 2;
										x = i + 1;
										y = j + 1;
										break a;
									}else {
										if(board[i][j-1] == 2) {
											five = 0;
											break;
										}else {
											winner = 2;
											x = i + 1;
											y = j + 1;
											break a;
										}
									}
								}else {
									five = 0;
									break;
								}
							}
						}
					}
					if(five == 5) {
						five = 0;
					}
					for(int k = 1; k < 6; k++) {
						if(i + k >= 19 || j + k >=19) {
							if(five == 4) {
								if(i - 1 < 0 || j - 1 < 0) {
									winner = 2;
									x = i + 1;
									y = j + 1;
									break a;
								}else {
									if(board[i-1][j-1] == 2) {
										five = 0;
										break;
									}else {
										winner = 2;
										x = i + 1;
										y = j + 1;
										break a;
									}
								}
							}
							five = 0;
							break;
						}else {
							if(board[i+k][j+k] == 2) {
								five++;
							}else {
								if(five == 4) {
									if(i - 1 < 0 || j - 1 < 0) {
										winner = 2;
										x = i + 1;
										y = j + 1;
										break a;
									}else {
										if(board[i-1][j-1] == 2) {
											five = 0;
											break;
										}else {
											winner = 2;
											x = i + 1;
											y = j + 1;
											break a;
										}
									}
								}else {
									five = 0;
									break;
								}
							}
						}
					}
					if(five == 5) {
						five = 0;
					}
					for(int k = 1; k < 6; k++) {
						if(i - k < 0 || j + k >=19) {
							if(five == 4) {
								if(i + 1 >= 19 || j - 1 < 0) {
									winner = 2;
									x = i + 1;
									y = j + 1;
									break a;
								}else {
									if(board[i+1][j-1] == 2) {
										five = 0;
										break;
									}else {
										winner = 2;
										x = i + 1;
										y = j + 1;
										break a;
									}
								}
							}
							five = 0;
							break;
						}else {
							if(board[i-k][j+k] == 2) {
								five++;
							}else {
								if(five == 4) {
									if(i + 1 >= 19 || j - 1 < 0) {
										winner = 2;
										x = i + 1;
										y = j + 1;
										break a;
									}else {
										if(board[i+1][j-1] == 2) {
											five = 0;
											break;
										}else {
											winner = 2;
											x = i + 1;
											y = j + 1;
											break a;
										}
									}
								}else {
									five = 0;
									break;
								}
							}
						}
					}
					if(five == 5) {
						five = 0;
					}
				}
			}
		}
		
		if(winner != 0) {
			System.out.println(winner + "\n" + x + " " + y);			
		}else {
			System.out.println(winner);
		}
	}
}

