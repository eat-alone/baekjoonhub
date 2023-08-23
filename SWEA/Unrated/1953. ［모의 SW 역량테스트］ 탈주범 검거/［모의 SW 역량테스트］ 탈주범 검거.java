import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N,M,R,C,L,map[][],sum;
    static boolean[][] v;
    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};
    static int[][] can = new int[][] {{1,2,5,6},{1,2,4,7},{1,3,4,5},{1,3,6,7}};
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());

        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            sum = 0;
            map = new int[N][M];
            v = new boolean[N][M];
            
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            toDo();
            System.out.println("#" + tc + " " + sum);
        }
    }
    static void toDo() {
        Queue<int[]> q = new ArrayDeque<int[]>();
        int time = 0;
        q.offer(new int[] {R,C});
        v[R][C] = true;

        while(time < L) {
            int size = q.size();
            sum += size;
            for(int i = 0; i < size; i++) {
                int temp[] = q.poll();
                int x = temp[0];
                int y = temp[1];
                switch (map[x][y]) {
                case 1://+
                    for(int j = 0; j < 4; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if(nx >= 0 && nx < N && ny >=0 && ny < M && !v[nx][ny]) {
                            for(int k = 0; k < 4; k++) {
                                if(map[nx][ny] == can[j][k]) {
                                    q.offer(new int[] {nx,ny});
                                    v[nx][ny] = true;
                                }
                            }
                        }
                    }
                    break;
                case 2://|
                    for(int j = 0; j < 2; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if(nx >= 0 && nx < N && ny >=0 && ny < M && !v[nx][ny]) {
                            for(int k = 0; k < 4; k++) {
                                if(map[nx][ny] == can[j][k]) {
                                    q.offer(new int[] {nx,ny});
                                    v[nx][ny] = true;
                                }
                            }
                        }
                    }
                    break;
                case 3://-
                    for(int j = 2; j < 4; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if(nx >= 0 && nx < N && ny >=0 && ny < M && !v[nx][ny]) {
                            for(int k = 0; k < 4; k++) {
                                if(map[nx][ny] == can[j][k]) {
                                    q.offer(new int[] {nx,ny});
                                    v[nx][ny] = true;
                                }
                            }
                        }
                    }
                    break;
                case 4: // ㄴ
                    for(int j = 0; j < 2; j++) {
                        int nx = x + dx[j*3];
                        int ny = y + dy[j*3];
                        if(nx >= 0 && nx < N && ny >=0 && ny < M && !v[nx][ny]) {
                            for(int k = 0; k < 4; k++) {
                                if(map[nx][ny] == can[j*3][k]) {
                                    q.offer(new int[] {nx,ny});
                                    v[nx][ny] = true;
                                }
                            }
                        }
                    }
                    break;
                case 5: //r
                	for(int j = 1; j < 4; j++) {
                		if(j == 2) {
                			continue;
                		}
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if(nx >= 0 && nx < N && ny >=0 && ny < M && !v[nx][ny]) {
                            for(int k = 0; k < 4; k++) {
                                if(map[nx][ny] == can[j][k]) {
                                    q.offer(new int[] {nx,ny});
                                    v[nx][ny] = true;
                                }
                            }
                        }
                    }
                    break;
                case 6://ㄱ
                	for(int j = 1; j < 3; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if(nx >= 0 && nx < N && ny >=0 && ny < M && !v[nx][ny]) {
                            for(int k = 0; k < 4; k++) {
                                if(map[nx][ny] == can[j][k]) {
                                    q.offer(new int[] {nx,ny});
                                    v[nx][ny] = true;
                                }
                            }
                        }
                    }
                    break;
                case 7://j
                	for(int j = 0; j < 3; j++) {
                		if(j==1) {
                			continue;
                		}
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if(nx >= 0 && nx < N && ny >=0 && ny < M && !v[nx][ny]) {
                            for(int k = 0; k < 4; k++) {
                                if(map[nx][ny] == can[j][k]) {
                                    q.offer(new int[] {nx,ny});
                                    v[nx][ny] = true;
                                }
                            }
                        }
                    }
                    break;
                }
            }
            time++;
        }
    }
}