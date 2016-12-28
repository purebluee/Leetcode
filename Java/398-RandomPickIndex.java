public class Solution {
    HashMap<Integer, ArrayList<Integer>> map;
    public Solution(int[] nums) {
        map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        int count = map.get(target).size();
        //generate a random integer from 0 to count-1.
        int index = 0 + (int)(Math.random() * (count - 1 - 0 + 1));
        return map.get(target).get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

//Reservoir sampling
/*
这道题指明了我们不能用太多的空间，那么省空间的随机方法只有水塘抽样了，LeetCode之前有过两道需要用这种方法的题目Shuffle an Array和Linked List Random Node。
那么如果了解了水塘抽样，这道题就不算一道难题了，我们定义两个变量，计数器cnt和返回结果res，我们遍历整个数组，如果数组的值不等于target，直接跳过；
如果等于target，计数器加1，然后我们在[0,cnt]范围内随机生成一个数字，如果这个数字是0，我们将res赋值为i即可
*/

public Solution(int[] nums) {
    this.nums=nums;
    this.rand = new Random();
}

public int pick(int target) {
    int index = -1;
    int count = 1;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target && rand.nextInt(count++) == 0) {
            index = i;
        }
    }
    return index;
}