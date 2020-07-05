class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            int num = target - nums[i];
            if(hash.containsKey(num)){
                return new int[]{hash.get(num), i};
            }
            hash.put(nums[i], i);
        }
        return null;
    }
}