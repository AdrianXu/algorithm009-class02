class GroupAnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hash = new HashMap<>();
        for(String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(hash.containsKey(key)){
                hash.get(key).add(str);
            }else{
                hash.put(key,new ArrayList<String>());
                hash.get(key).add(str);
            }
        }
        return new ArrayList<List<String>>(hash.values());
    }
}