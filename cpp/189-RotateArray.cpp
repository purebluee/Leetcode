//[1,2,3,4,5,6,7]
//[7,6,5,4,3,2,1]
//[5,6,7,1,2,3,4]
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if (nums.size() == 0 || k == 0) {
            return;
        }
        if (k > nums.size()) {
            k %= nums.size();
        }
        reverse(nums, 0, nums.size() - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.size() - 1);
    }
private:
    void reverse(vector<int>& nums, int i, int j) {
        while (i <= j) {
            swap(nums[i], nums[j]);
            i++;
            j--;
        }
    }
};
