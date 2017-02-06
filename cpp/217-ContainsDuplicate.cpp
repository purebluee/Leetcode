class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        if (nums.size() == 0 || nums.size() == 1)
            return false;
        unordered_set<int> hs;
        for (int num : nums) {
            if (hs.find(num) != hs.end())
                return true;
            hs.insert(num);
        }
        return nums.size() != hs.size();
    }
};
