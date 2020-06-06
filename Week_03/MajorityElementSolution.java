class MajorityElementSolution {
    public int majorityElement(int[] nums) {
        return majorityElementHelper(0 ,nums);
    }
    int majorityElementHelper(int start, int[] nums){
        int current = nums[start];
        int count = 1;
        for(int i = start+1; i < nums.length; i++){
            if(nums[i] == current){
                count++;
            }else{
                count--;
            }
            if(count == 0){
               return majorityElementHelper(i+1, nums);
            }
        }
        return current;
    }
}