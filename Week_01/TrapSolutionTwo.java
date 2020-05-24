class TrapSolutionTwo {
    public int trap(int[] height) {
        int sum = 0;
        int left = 1;
        int right = height.length -2;
        int left_height = 0;
        int right_height = 0;
        for(int i = 1; i < height.length -1; i++){
            if(height[left - 1] < height[right + 1]){
                left_height = Math.max(left_height,height[left - 1]);
                if(left_height > height[left]){
                    sum = sum + left_height - height[left];
                }
                left ++;
            }else{
                right_height = Math.max(right_height,height[right + 1]);
                if(right_height > height[right]){
                    sum = sum + right_height - height[right];
                }
                right --;
            }
        }
        return sum;
    }
}