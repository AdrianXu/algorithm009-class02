class JumpSolution {
    public int jump(int[] nums) {
        int max_position = 0;
        int end = 0;
        int step = 0;
        for(int i = 0; i < nums.length - 1; i++){
            max_position = Math.max(max_position, i + nums[i]);
            if(end == i){
                end = max_position;
                step++;
            }    
        }
        return step;
    }
}