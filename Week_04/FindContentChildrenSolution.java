class FindContentChildrenSolution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int g_index = 0, s_index = 0, count = 0;
        while(g_index != g.length && s_index != s.length){
            if(s[s_index] >= g[g_index]){
                s_index++;
                g_index++;
                count++;
            }else{
                s_index++;
            }
        }
        return count;
    }
}