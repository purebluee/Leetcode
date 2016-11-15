public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int left = 0, right = height.length - 1, maxA = 0;
        while (left < right){
            maxA = Math.max(Math.min(height[left], height[right]) * (right - left), maxA);
            if (height[left] >= height[right] && left < right){
                right--;
            }else if (height[left] < height[right] && left < right){
                left++;
            }
        }
        return maxA;
    }
}