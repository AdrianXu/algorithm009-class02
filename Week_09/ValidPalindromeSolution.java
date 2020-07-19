class ValidPalindromeSolution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                int left2 = left + 1;
                int right2 = right;
                boolean isvalid = true;
                while(left2 < right2){
                    if(s.charAt(left2) != s.charAt(right2)){
                        isvalid = false;
                        break;
                    }
                    left2++;
                    right2--;
                }
                if(isvalid)return true;
                
                left2 = left;
                right2 = right - 1;
                while(left2 < right2){
                    if(s.charAt(left2) != s.charAt(right2)){
                        return false;
                    }
                    left2++;
                    right2--;
                }
                return true;
            }
            left++;
            right--;
        }
        return true;
    }
}