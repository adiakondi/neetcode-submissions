class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Bucket Sort implementation
        Hashtable<Integer, Integer> counts = new Hashtable<Integer, Integer>();
        int[] output = new int[k];
        List<Integer>[] buckets = new List[nums.length + 1];

        // Track key frequencies using Hashtable
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(counts.containsKey(num)) {
                counts.computeIfPresent(num, (key, val) -> val + 1); 
            }
            else{
                counts.put(num, 1);
            }
        }
        
        // Initialize buckets with empty lists so no errors when indexing
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new ArrayList<>();
        }
        // Now flip logic: key is frequency and value is the element 
        var entries = counts.entrySet();
        for(var entry: entries) {
            buckets[entry.getValue()].add(entry.getKey());
        }
        // Most frequent elements stored at ending key/idx of buckets array
        int added = 0;
        for(int i = buckets.length-1; i >= 0; i--) {
            List<Integer> list = buckets[i];
            for(int j = 0; j < list.size(); j++) {
                output[added] = list.get(j);
                added++;
                if(added == k) {
                    return output;
                }
            }
        }
        return null;
    }
}
