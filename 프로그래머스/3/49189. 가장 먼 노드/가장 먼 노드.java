import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        //간선 정보 저장할 배열 선언
        List<Integer>[] edgeMap = new ArrayList[20001];
        //방문체크
        boolean[] v = new boolean[20001];
        //bfs 큐 선언
        Queue<Integer> q = new ArrayDeque<>();
        //간선 배열 초기화
        for(int i = 0; i < 20001; i++){
            edgeMap[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge.length; i++){


            int start = edge[i][0];
            int end = edge[i][1];

            edgeMap[start].add(end);
            edgeMap[end].add(start);
        }

        //시작 노드를 넣고 탐색 시작
        q.offer(1);
        //시작 노드 방문 체크
        v[1] = true;
        //사이즈 체크
        int size = 0;
        while(!q.isEmpty()){
            size = q.size();
            System.out.println(q);
            for(int i = 0; i < size; i++){
                int temp = q.poll();
                for(int j = 0; j < edgeMap[temp].size(); j++){
                    // System.out.println(edgeMap[temp]);
                    int target = edgeMap[temp].get(j);
                    if(target != 0 && !v[target]){
                        v[target] = true;
                        q.offer(target);
                    }
                }
            }
        }

        int answer = size;
        return answer;
    }
}