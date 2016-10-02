public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null){
            return 0;
        }
        int currMin = prices[0];
        int max = 0;
        for (int price : prices){
            currMin = Math.min(currMin, price);
            max = Math.max(max, price - currMin);
        }
        return max;
    }
}