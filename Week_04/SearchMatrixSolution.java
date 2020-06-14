class SearchMatrixSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rn = matrix.length;
        int cn = matrix[0].length;
        int left = 0, right = rn * cn - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            int row = mid / cn;
            int col = mid - row * cn;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] >target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}