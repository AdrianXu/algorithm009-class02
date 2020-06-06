class PermuteSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited, list, new ArrayList<Integer>());
        return list;
    }
    void backtracking(int[] nums, boolean[] visited, List<List<Integer>> list, List<Integer> temp){
        if(temp.size() == nums.length){
            list.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i])continue;
            temp.add(nums[i]);
            visited[i] = true;
            backtracking(nums, visited, list, temp);
            visited[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}