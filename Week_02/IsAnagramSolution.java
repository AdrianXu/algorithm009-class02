class IsAnagramSolution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] alph = new int[26];
        for(int i = 0; i < s.length(); i++){
            alph[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            alph[t.charAt(i) - 'a']--;
            if(alph[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}