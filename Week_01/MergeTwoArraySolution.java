class MergeTwoArraySolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int index = nums1.length - 1;
        while(len1 >= 0 && len2 >= 0){
            if(nums2[len2] > nums1[len1]){
                nums1[index--] = nums2[len2 --];
            }else{
                nums1[index--] = nums1[len1 --];
            }
        }
        System.arraycopy(nums2 , 0 , nums1 , 0 , len2 + 1);
    }
}