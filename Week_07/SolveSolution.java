class SolveSolution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        for(int i = 0; i < n; i++){
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(char[][] board, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X' || board[row][col] == '#'){
            return;
        }
        if(board[row][col] == 'O'){
            board[row][col] = '#';
            dfs(board, row + 1, col);
            dfs(board, row - 1, col);
            dfs(board, row, col + 1);
            dfs(board, row, col - 1);
        }
    }
}