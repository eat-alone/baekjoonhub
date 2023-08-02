class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] alpa = new int[27];
        
        for(int i = 0; i < keymap.length; i++) { // i = 0 => "ABACD"
        	for(int j = 0; j < keymap[i].length(); j++) { // j  = 0 ~ 4
        		//System.out.println((keymap[i].charAt(j) - 64) + " " + j);
        		if(alpa[keymap[i].charAt(j) - 64] == 0) {
        			alpa[keymap[i].charAt(j) - 64] = j + 1;
        		}else if(j + 1 < alpa[keymap[i].charAt(j) - 64]) {
        			alpa[keymap[i].charAt(j) - 64] = j + 1;
        		}
        	}
        }
        //System.out.println(Arrays.toString(alpa));
        for(int i = 0; i < targets.length; i++) {
        	for(int j = 0; j < targets[i].length(); j++) {
        		if(alpa[targets[i].charAt(j)-64] == 0) {
        			answer[i] = -1;
        			break;
        		}else {
        			answer[i] = answer[i] + alpa[targets[i].charAt(j)-64];
        		}
        	}
        }
        return answer;
    }
}