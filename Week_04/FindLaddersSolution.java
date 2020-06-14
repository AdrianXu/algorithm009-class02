class FindLaddersSolution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> list = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || !wordSet.contains(endWord)){
            return list;
        } 
        
        Map<String, Set<String>> successors = new HashMap<>();
        boolean found = bidirectionalBfs(beginWord, endWord, wordSet, successors);
        if(!found){
            return list;
        }
        Deque<String> path = new ArrayDeque<>();
        path.addLast(beginWord);
        dfs(beginWord, endWord, successors, path, list);
        return list;
    }

    boolean bidirectionalBfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> successors){
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        int wordLength = beginWord.length();
        boolean forward = true;
        boolean found = false;
        while(!beginVisited.isEmpty() && !endVisited.isEmpty()){
            if(beginVisited.size() > endVisited.size()){
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;

                forward = !forward;
            }
            Set<String> nextLevelVisited = new HashSet<>();
            for(String currentWord: beginVisited){
                char[] chars = currentWord.toCharArray();
                for(int i = 0; i < chars.length; i++){
                    char old = chars[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(chars[i] == c)continue;
                        chars[i] = c;
                        String nextWord = new String(chars);
                        if(wordSet.contains(nextWord)){
                            if(endVisited.contains(nextWord)){
                                found = true;
                                addToSuccessors(successors, forward, currentWord, nextWord);
                            }
                            if(!visited.contains(nextWord)){
                                nextLevelVisited.add(nextWord);
                                addToSuccessors(successors, forward, currentWord, nextWord);
                            }
                        }
                    }
                    chars[i] = old;
                }
            }
            beginVisited = nextLevelVisited;
            visited.addAll(nextLevelVisited);
            if(found){
                break;
            }
        }
        return found;
    }

    void dfs(String beginWord, String endWord, Map<String, Set<String>> successors, Deque<String> path, List<List<String>> list){
        if(beginWord.equals(endWord)){
            list.add(new ArrayList<String>(path));
            return;
        }
        if(!successors.containsKey(beginWord)){
            return;
        }
        Set<String> successorsWords = successors.get(beginWord);
        for(String successor: successorsWords){
            path.addLast(successor);
            dfs(successor, endWord, successors, path, list);
            path.removeLast();
        }
    }

    void addToSuccessors(Map<String, Set<String>> successors, boolean forward, String currentWord, String nextWord){
        if(!forward){
            String temp = currentWord;
            currentWord = nextWord;
            nextWord = temp;
        }
        if(successors.containsKey(currentWord)){
            successors.get(currentWord).add(nextWord);
        }else{
            Set<String> newSet = new HashSet<>();
            newSet.add(nextWord);
            successors.put(currentWord, newSet);
        }
    }
}