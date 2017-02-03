//[2,7,11,15] target = 9
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
        if (nums.size() < 2)
            return res;
        int i1 = 0, i2 = nums.size() - 1;
        while (i1 < i2){
            if (nums[i1] + nums[i2] == target){
                res.push_back(i1+1);
                res.push_back(i2+1);
                return res;
            }else if (nums[i1] + nums[i2] > target){
                i2--;
            }else{
                i1++;
            }
        }
        return res;
    }
};
