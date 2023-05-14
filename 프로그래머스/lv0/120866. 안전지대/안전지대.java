class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        if(board.length <= 1){
            if(board[0][0] == 1){
                answer = 0;
                return answer;
            }else{
                answer = 1;
                return answer;
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j]);
                if(board[i][j] == 1){
                    if(i - 1 < 0 && j - 1 < 0){//i = 0 j = 0
                        if(board[i][j+1] != 1){
                            board[i][j+1] = 2;
                        }
                        if(board[i+1][j] != 1){
                            board[i+1][j] = 2;
                        }
                        if(board[i+1][j+1] != 1){
                            board[i+1][j+1] = 2;
                        }
                    }else if(i - 1 < 0 && j + 1 >= board[i].length){//i = 0 j = n
                        if(board[i][j-1] != 1){
                            board[i][j-1] = 2;
                        }
                        if(board[i+1][j] != 1){
                            board[i+1][j] = 2;
                        }
                        if(board[i+1][j-1] != 1){
                            board[i+1][j-1] = 2;
                        }
                    }else if(i + 1 >= board[i].length && j - 1 < 0){//i = n j = 0
                        if(board[i][j+1] != 1){
                            board[i][j+1] = 2;
                        }
                        if(board[i-1][j] != 1){
                            board[i-1][j] = 2;
                        }
                        if(board[i-1][j+1] != 1){
                            board[i-1][j+1] = 2;
                        }
                    }else if(i + 1 >= board[i].length && j + 1 >= board[i].length){//i = n j = n
                        if(board[i][j-1] != 1){
                            board[i][j-1] = 2;
                        }
                        if(board[i-1][j] != 1){
                            board[i-1][j] = 2;
                        }
                        if(board[i-1][j-1] != 1){
                            board[i-1][j-1] = 2;
                        }
                    }else if(i - 1 < 0){//i = 0 j = 1
                        if(board[i][j-1] != 1){
                            board[i][j-1] = 2;
                        }
                        if(board[i][j+1] != 1){
                            board[i][j+1] = 2;
                        }
                        if(board[i+1][j+1] != 1){
                            board[i+1][j+1] = 2;
                        }
                        if(board[i+1][j-1] != 1){
                            board[i+1][j-1] = 2;
                        }
                        if(board[i+1][j] != 1){
                            board[i+1][j] = 2;
                        }
                    }else if(i + 1 >= board[i].length){
                        if(board[i][j-1] != 1){
                            board[i][j-1] = 2;
                        }
                        if(board[i][j+1] != 1){
                            board[i][j+1] = 2;
                        }
                        if(board[i-1][j+1] != 1){
                            board[i-1][j+1] = 2;
                        }
                        if(board[i-1][j-1] != 1){
                            board[i-1][j-1] = 2;
                        }
                        if(board[i-1][j] != 1){
                            board[i-1][j] = 2;
                        }
                    }else if(j + 1 >= board[i].length){
                        if(board[i][j-1] != 1){
                            board[i][j-1] = 2;
                        }
                        if(board[i+1][j-1] != 1){
                            board[i+1][j-1] = 2;
                        }
                        if(board[i-1][j-1] != 1){
                            board[i-1][j-1] = 2;
                        }
                        if(board[i-1][j] != 1){
                            board[i-1][j] = 2;
                        }
                        if(board[i+1][j] != 1){
                            board[i+1][j] = 2;
                        }
                    }else if(j - 1 < 0){
                        if(board[i][j+1] != 1){
                            board[i][j+1] = 2;
                        }
                        if(board[i+1][j+1] != 1){
                            board[i+1][j+1] = 2;
                        }
                        if(board[i-1][j+1] != 1){
                            board[i-1][j+1] = 2;
                        }
                        if(board[i-1][j] != 1){
                            board[i-1][j] = 2;
                        }
                        if(board[i+1][j] != 1){
                            board[i+1][j] = 2;
                        }
                    }else{
                        if(board[i][j+1] != 1){
                            board[i][j+1] = 2;
                        }
                        if(board[i+1][j+1] != 1){
                            board[i+1][j+1] = 2;
                        }
                        if(board[i-1][j+1] != 1){
                            board[i-1][j+1] = 2;
                        }
                        if(board[i-1][j] != 1){
                            board[i-1][j] = 2;
                        }
                        if(board[i+1][j] != 1){
                            board[i+1][j] = 2;
                        }
                        if(board[i][j-1] != 1){
                            board[i][j-1] = 2;
                        }
                        if(board[i+1][j-1] != 1){
                            board[i+1][j-1] = 2;
                        }
                        if(board[i-1][j-1] != 1){
                            board[i-1][j-1] = 2;
                        }
                    }
                }
            }
            System.out.println("");
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j]);
                if(board[i][j] == 0){
                    answer++;
                }
            }
            System.out.println("");
        }
        return answer;
    }
}