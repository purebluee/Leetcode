public class Solution {
    //with O(n) space
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0){
            return 0;
        }
        int len = costs.length;
        for (int i = 1; i < costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(costs[len-1][0], Math.min(costs[len-1][1], costs[len-1][2]));
    }

    //with constant space
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0){
            return 0;
        }
        int len = costs.length;
        int last0 = 0, last1 = 0, last2 = 0;
        int curr0 = 0, curr1 = 0, curr2 = 0;
        for (int i = 0; i < costs.length; i++){
            last0 = curr0; 
            last1 = curr1;
            last2 = curr2;
            curr0 = Math.min(last1, last2) + costs[i][0];
            curr1 = Math.min(last0, last2) + costs[i][1];
            curr2 = Math.min(last0, last1) + costs[i][2];
        }
        return Math.min(curr0, Math.min(curr1, curr2));
    }

}