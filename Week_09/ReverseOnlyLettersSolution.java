class ReverseOnlyLettersSolution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0, right = chars.length - 1;
        while(left < right){
            while(left < right && isCharacter(chars[left]) && isCharacter(chars[right])){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            if(!isCharacter(chars[left]))left++;
            if(!isCharacter(chars[right]))right--;
        }
        return new String(chars);
    }

    boolean isCharacter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}