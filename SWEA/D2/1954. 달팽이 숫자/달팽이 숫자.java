import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int testCase = 0; testCase < T; testCase++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            
            int x = 0;
            int y = 0;
            int idx = 1;
            while( idx <= n * n ) { // idx 가 1 부터 n*n번이 될때까지.
                map[x][y] = idx;//idx 할당
                if(y+1 < n && map[x][y+1] == 0) { //배열 끝이 아니고 할당도 안되어있다면
                	y++;                          //오른쪽으로 이동
                }else if(x + 1 < n && map[x+1][y] == 0) { 
                	x++;                          //아래로 이동
                }else if(y - 1 >= 0 && map[x][y-1] == 0) {
                	y--;                          //왼쪽으로 이동
                }else if(x - 1 >= 0 && map[x-1][y] == 0) { //위로 올라가야 할때
                	while(map[x-1][y] == 0) {              //할당된 배열을 만나면 종료
                		x--;                               //위로 이동
                		idx++;                             //숫자 증가
                		map[x][y] = idx;                   //할당
                	}
                	continue; // 숫자증가 연산 중복 회피
                }
                idx++;//idx증가
            }
            System.out.println("#" + (testCase + 1));
            
            for(int i = 0; i < n; i++) {
            	for(int j = 0; j < n; j++) {
            		System.out.print(map[i][j]+" ");
            	}
            	System.out.println();
            }
        }
    }
}
