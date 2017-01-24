class Solution {
public:
    void swap(vector<int>& nums, int p1, int p2){
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }

    void sortColors(vector<int>& nums) {
        if (nums.size() == 0){
            return;
        }
        int p1 = 0, p2 = nums.size() - 1, curr = 0;
        while (p1 <= p2 && curr <= p2){
            if (nums[curr] == 0){
                swap(nums, curr, p1);
                p1++;
                curr++;
            }else if (nums[curr] == 1){
                curr++;
            }else{
                swap(nums, curr, p2);
                //attention here!
                //no curr++;
                p2--;
            }
        }
    }
};
