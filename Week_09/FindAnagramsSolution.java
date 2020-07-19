class FindAnagramsSolution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();
        List<Integer> res = new ArrayList<>();
        
        int[] needs = new int[26];
        for(int i = 0; i < arrP.length; i++){
            needs[arrP[i] - 'a']++;
        }
        int[] window = new int[26];
        int left = 0, right = 0;
        while(right < arrS.length){
            int curR = arrS[right] - 'a';
            right++;
            window[curR]++;

            while(window[curR] > needs[curR]){
                int curL = arrS[left] - 'a';
                left++;
                window[curL]--;
            }

            if(right - left == arrP.length){
                res.add(left);
            }
        }
        return res;
    }

}