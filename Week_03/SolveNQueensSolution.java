class SolveNQueensSolution {
    private Set<Integer> col;
    private Set<Integer> master;
    private Set<Integer> salve;
    private List<List<String>> list;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        list = new ArrayList<>();
        if(n == 0){
            return list;
        }
        col = new HashSet<>();
        master = new HashSet<>();
        salve = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        backtracking(stack, 0);
        return list;
    }

    void backtracking(Stack<Integer> stack, int row){
        if(row == n){
            list.add(convert2board(stack, n));
            return;
        }
        for(int i = 0; i < n; i++){
            if(!col.contains(i) && !master.contains(row + i) && !salve.contains(row - i)){
                stack.push(i);
                col.add(i);
                master.add(row+i);
                salve.add(row-i);

                backtracking(stack, row + 1);

                stack.pop();
                col.remove(i);
                master.remove(row+i);
                salve.remove(row-i);
            }
        }
    }
    List<String> convert2board(Stack<Integer> stack, int n){
        List<String> board = new ArrayList<>();
        for(Integer index: stack){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                sb.append(".");
            }
            sb.replace(index, index+1, "Q");
            board.add(sb.toString());
        }
        return board;
    }
}