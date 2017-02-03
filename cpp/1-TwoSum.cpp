class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
        unordered_map<int, int> map;
        if (nums.size() < 2)
            return res;
        for (int i = 0; i < nums.size(); i++){
            if (map.find(target - nums[i]) == map.end()){
                map[nums[i]] = i;
            }else{
                res.push_back(map[target - nums[i]]);
                res.push_back(i);
                return res;
            }
        }
        return res;
    }
};
