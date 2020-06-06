class LetterCombinationsSolution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> hash = new HashMap<>();
        hash.put(2, "abc");
        hash.put(3, "def");
        hash.put(4, "ghi");
        hash.put(5, "jkl");
        hash.put(6, "mno");
        hash.put(7, "pqrs");
        hash.put(8, "tuv");
        hash.put(9, "wxyz");
        List<String> list = new ArrayList<>();
        if(digits.equals("")){
            return list;
        }
        backtracking(0, digits, hash, list, "");
        return list;
    }
    void backtracking(int index, String digits, Map<Integer, String> hash, List<String> list, String str){
        if(str.length() == digits.length()){
            list.add(str);
            return;
        }
        for(char c: hash.get(digits.charAt(index) - '0').toCharArray()){
            backtracking(index+1, digits, hash, list, str+c);
        }
    }
}