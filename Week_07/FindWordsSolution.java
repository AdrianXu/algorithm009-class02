class FindWordsSolution {
    class TrieNode {
        Map<Character, TrieNode> hash = new HashMap<>();
        String word = null;
    }
    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return result;
        }
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; i++){
            TrieNode node = root;
            for(Character c: words[i].toCharArray()){
                if(!node.hash.containsKey(c)){
                    node.hash.put(c, new TrieNode());
                }
                node = node.hash.get(c);
            }
            node.word = words[i];
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.hash.containsKey(board[i][j])){
                    dfs(board, i, j, root);
                }
            }
        }
        return result;
    }

    void dfs(char[][] board, int row, int col, TrieNode parentNode){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#' || !parentNode.hash.containsKey(board[row][col])){
            return;
        }
        Character c = board[row][col];
        TrieNode node = parentNode.hash.get(c);
        if(node.word != null){
            result.add(node.word);
            node.word = null;
        }
        board[row][col] = '#';
        dfs(board, row + 1, col, node);
        dfs(board, row - 1, col, node);
        dfs(board, row, col + 1, node);
        dfs(board, row, col - 1, node);
        board[row][col] = c;
    }
}