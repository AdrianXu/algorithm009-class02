class CombineSolution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(n, k, list, new ArrayList<Integer>(), 1);
        return list;
    }
    void backtracking(int n, int k, List<List<Integer>> list, List<Integer> temp, int start){
        if(temp.size() == k){
            list.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = start; i <= n; i++){
            temp.add(i);
            backtracking(n, k, list, temp, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}