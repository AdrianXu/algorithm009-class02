class MergeSolution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <=1){
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<int[]> res = new ArrayList<>();
        int index = 0;
        while(index < intervals.length){
            int left = intervals[index][0];
            int right = intervals[index][1];
            while(index < intervals.length-1 && right >= intervals[index+1][0]){
                right = Math.max(right, intervals[index+1][1]);
                index++;
            }
            res.add(new int[]{left, right});
            index++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}