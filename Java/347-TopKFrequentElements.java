// use an array to save numbers into different bucket whose index is the frequency
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[nums.length+1];
        for(int n:map.keySet()){
            int freq = map.get(n);
            if(bucket[freq]==null)
                bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }
        
        List<Integer> res = new LinkedList<>();
        for(int i=bucket.length-1; i>0 && k>0; --i){
            if(bucket[i]!=null){
                List<Integer> list = bucket[i]; 
                res.addAll(list);
                k-= list.size();
            }
        }
        
        return res;
    }
}



// use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
           
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        List<Integer> res = new ArrayList<>();
        while(res.size() < k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}

//use maxHeap with comparator
public List<Integer> topKFrequent(int[] nums, int k) {
    Queue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
        @Override
        public int compare(int[] q1, int[]q2) {
            return q2[1] - q1[1];
        }
    });

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int num : nums) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        queue.offer(new int[]{entry.getKey(), entry.getValue()});
    }
    
    List<Integer> result = new ArrayList<Integer>();

    while (result.size() < k) {
        result.add(queue.poll()[0]);
    }
    
    return result;
}
