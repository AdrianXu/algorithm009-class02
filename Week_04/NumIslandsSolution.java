class NumIslandsSolution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rn = grid.length;
        int cn = grid[0].length;
        int num_Islands = 0;
        for(int r = 0; r < rn; r++){
            for(int c = 0; c < cn; c++){
                if(grid[r][c] == '1'){
                    num_Islands++;
                    dfs(grid, r, c);
                }
            }
        }
        return num_Islands;
    }
    void dfs(char[][] grid, int r, int c){
        int rn  = grid.length;
        int cn = grid[0].length;
        if(r < 0 || r >= rn || c < 0 || c >= cn || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}