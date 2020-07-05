class MaxSumSubmatrixSolution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length; 
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < cols; i++){
            int[] rowSum = new int[rows];
            for(int l = i ; l < cols; l++){
                for(int r = 0; r < rows; r++){
                    rowSum[r] += matrix[r][l];
                }
                max = Math.max(max, dpMax(rowSum, k));
                if(max == k) return max;
            }
        }
        return max;
    }
    int dpMax(int[] arr, int k){
        int rowSum = arr[0], rowMax = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(rowSum > 0){
                rowSum += arr[i];
            }else{
                rowSum = arr[i];
            }
            if(rowSum > rowMax) rowMax = rowSum;
        }
        if(rowMax <= k) return rowMax;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                if(sum > max && sum <= k)max = sum;
                if(max == k) return max;
            }
        }
        return max;
    }
}