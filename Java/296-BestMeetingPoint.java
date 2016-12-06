/*
The idea is the expand the question from 1-D to 2-D, using the same observation:

It will cost less distance if the meeting point is near the "major population".
How the find the meeting point? -> Two pointer
How to do it 2-D? -> Find horizontal, then vertical.
*/
public class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0;j < grid[0].length; j++){
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }
        return helper(row) + helper(col);
    }
    public int helper(int[] nums){
        if(nums.length == 0) return 0;
        int left = 0, right = 0, low = 0, high = nums.length-1;
        while(low < high)
            if(left + nums[low] <= right + nums[high]){ 
                left += nums[low];
                low++;
            }else{
                right += nums[high];
                high--;
            }
        int res = 0;
        for(int i = 0; i < nums.length; i++) 
            res += nums[i] * Math.abs(low - i);
        return res;
    }
}

//another sol
public int minTotalDistance(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    
    List<Integer> I = new ArrayList<>(m);
    List<Integer> J = new ArrayList<>(n);
    
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 1){
                I.add(i);
                J.add(j);
            }
        }
    }
    
    return getMin(I) + getMin(J);
}

private int getMin(List<Integer> list){
    int ret = 0;
    
    Collections.sort(list);
    
    int i = 0;
    int j = list.size() - 1;
    while(i < j){
        ret += list.get(j--) - list.get(i++);
    }
    
    return ret;
}