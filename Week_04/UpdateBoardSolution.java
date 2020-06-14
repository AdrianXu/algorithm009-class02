class UpdateBoardSolution {
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }
    void dfs(char[][] board, int x, int y){
        int rn = board.length;
        int cn = board[0].length;
        if(x < 0 || x >= rn || y < 0 || y >= cn){
            return;
        }
        if(board[x][y] == 'M' || board[x][y] == 'X'){
            board[x][y] = 'X';
        }else if(board[x][y] == 'E'){
            board[x][y] = 'B';
            int count = getNum(board, x, y);
            if(count == 0){
                for(int i = 0; i < 8; i++){
                    dfs(board, x + dx[i], y + dy[i]);
                }
            }else{
                board[x][y] = (char)(count + '0');
            }
        }
    }

    int getNum(char[][] board, int x, int y){
        int rn = board.length;
        int cn = board[0].length;
        int count = 0;
        for(int i = 0; i < 8; i++){
            int new_x = x + dx[i];
            int new_y = y + dy[i];
            if(new_x < 0 || new_x >= rn || new_y < 0 || new_y >= cn){
                continue;
            }
            if(board[new_x][new_y] == 'M'){
                count++;
            }
        }
        return count;
    }
}