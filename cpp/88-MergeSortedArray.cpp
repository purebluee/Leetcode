class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int end = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0){
            cout << m << " " << n << " " << end << endl;
            if (nums1[m] > nums2[n]){
                nums1[end] = nums1[m];
                m--;
                end--;
            }else{
                nums1[end] = nums2[n];
                n--;
                end--;
            }
        }

        while (n >= 0){
            nums1[n] = nums2[n];
            n--;
        }
    }
};
