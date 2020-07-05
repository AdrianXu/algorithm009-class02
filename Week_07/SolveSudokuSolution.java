class SolveSudokuSolution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    block[i/3*3 + j/3][num] = true;
                }
            }
        }
        dfs(board, row, col, block, 0, 0);
    }
    boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j){
        while(board[i][j] != '.'){
            if(++j >= 9){
                i++;
                j = 0;
            }
            if(i >= 9){
                return true;
            }
        }
        for(int num = 0; num < 9; num++){
            int blockIndex = i/3*3 + j/3;
            if(!row[i][num] && !col[j][num] && !block[blockIndex][num]){
                board[i][j] = (char)('1' + num);
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                if(dfs(board, row, col, block, i, j)){
                    return true;
                }else{
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blockIndex][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
}