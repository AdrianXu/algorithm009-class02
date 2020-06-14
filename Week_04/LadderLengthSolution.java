class LadderLengthSolution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || !wordSet.contains(endWord)){
            return 0;
        }
        wordSet.add(beginWord);

        Queue<String> queue1 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        queue1.offer(beginWord);
        visited1.add(beginWord);

        Queue<String> queue2 = new LinkedList<>();
        Set<String> visited2 = new HashSet<>();
        queue2.offer(endWord);
        visited2.add(endWord);

        int depth = 0;
        while(queue1.size() != 0 && queue2.size() != 0){
            if(queue1.size() > queue2.size()){
                Queue<String> temp = queue1;
                queue1 = queue2;
                queue2 = temp;

                Set<String> set = visited1;
                visited1 = visited2;
                visited2 = set;
            }
            ++depth;
            int size = queue1.size();
            while(size-- > 0){
                String word = queue1.poll();
                char[] chars = word.toCharArray();
                for(int i = 0; i < chars.length; i++){
                    char temp = chars[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        chars[i] = c;
                        String newStr = new String (chars);
                        if(visited1.contains(newStr)){
                            continue;
                        }
                        if(visited2.contains(newStr)){
                            return depth + 1;
                        }
                        if(wordSet.contains(newStr)){
                            visited1.add(newStr);
                            queue1.offer(newStr);
                        }
                    }
                    chars[i] = temp;
                }
            }
        }
        return 0;
    }
}