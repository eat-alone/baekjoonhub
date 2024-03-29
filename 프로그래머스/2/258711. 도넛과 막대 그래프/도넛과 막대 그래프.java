import java.util.*;

class Solution {
    
    static Map<Integer ,List<Integer>> nodes = new HashMap<>();
    static int[] endPoint = new int[1000001];
    static int[] startPoint = new int[1000001];
    static int startNode;
    static int circleGrape = 0;
    static int stickGrape = 0;
    static int eightGrape = 0;
    
    public int[] solution(int[][] edges) {
        for(int i = 0; i < edges.length; i++){
            int start = edges[i][0];
            int end = edges[i][1];

            startPoint[start]++;
            endPoint[end]++;

            if(nodes.containsKey(start)){
                nodes.get(start).add(end);
            }else{
                nodes.put(start, new LinkedList<Integer>());
                nodes.get(start).add(end);
            }
        }

        for(int i = 1; i < 1000001; i++){
            if(endPoint[i] == 0){
                if(startPoint[i] >= 2){
                    startNode = i;
                }
            }
        }
        //시작 노드가 가지고 있는 연결 리스트를 가져온다
        List<Integer> nodeList = nodes.get(startNode);
        int size = nodeList.size();
        //리스트 사이즈만큼 반복 실행
        for(int i = 0; i < size; i++){
            //각 그래프의 첫 노드 번호를 기억해두고
            int tnode = nodeList.get(i);
            //탐색을 위한 큐 생성
            Queue<Integer> q = new ArrayDeque<>();
            //시작을 큐에 넣고
            q.offer(tnode);
            //탐색 실행
            while(!q.isEmpty()){
                int temp = q.poll();
                //노드가 가지고 있는 연결 리스트를 가져온다
                List<Integer> tempList = nodes.get(temp);
                if(tempList == null){
                    break;
                }
                if(tempList.size() == 2) {
                    eightGrape++;
                }else {
                    int next = tempList.get(0);
                    if (next == tnode){
                        circleGrape++;
                    }else{
                        q.offer(next);
                    }
                }
            }
        }

        int[] result = new int[] {startNode, circleGrape, size - circleGrape - eightGrape, eightGrape};
        
        return result;
    }
}