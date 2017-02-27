//[1,2,3,2,4,2,1]
class Solution {
public:
    int maxArea(vector<int>& height) {
        int maxWater = 0, left = 0, right = height.size() - 1;
        while (left < right) {
            int currWater = (right - left) * min(height[left], height[right]);
            maxWater = max(maxWater, currWater);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
};
