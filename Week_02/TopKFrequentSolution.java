class TopKFrequentSolution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(Integer i: nums){
            if(count.containsKey(i)){
                count.put(i, count.get(i)+1);
            }else{
                count.put(i, 1);
            }
        }
        PriorityQueue<Integer> pq = new  PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1,Integer i2){
                return count.get(i1) - count.get(i2);
            }
        });
        for(Integer key: count.keySet()){
            if(pq.size() < k){
                pq.offer(key);
            }else if( count.get(pq.peek()) < count.get(key)){
                pq.poll();
                pq.offer(key);
            }
        }
        int[] res = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            res[index++] = pq.poll();
        }
        return res;
    }
}