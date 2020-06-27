class MaximalSquareSolution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];
        int maxSide = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j]) + 1;
                    maxSide = Math.max(maxSide, dp[i+1][j+1]);
                }
            }
        }
        return maxSide * maxSide;
    }
}