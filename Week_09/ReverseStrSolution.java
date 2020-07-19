class ReverseStrSolution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int step = k * 2;
        int left = 0, right = len - 1;
        while(left < right){
            int start = left;
            int end = Math.min(left + k - 1, right);
            while(start < end){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
            left += step;
        }
        return new String(chars);
    }
}