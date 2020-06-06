class PermuteUniqueSolution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, list, visited, new ArrayList<Integer>());
        return list;
    }
    void backtracking(int[] nums, List<List<Integer>> list, boolean[] visited, List<Integer> temp){
        if(temp.size() == nums.length){
            list.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i])continue;
            if(i > 0 && nums[i] == nums[i-1] && visited[i-1])break;
            temp.add(nums[i]);
            visited[i] = true;
            backtracking(nums, list, visited, temp);
            visited[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}