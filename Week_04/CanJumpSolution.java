class CanJumpSolution {
    public boolean canJump(int[] nums) {
        int max_position = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > max_position){
                return false;
            }
            max_position = Math.max(max_position, i + nums[i]);
        }
        return true;
    }
}