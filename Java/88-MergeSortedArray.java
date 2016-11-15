
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = n + m - 1;
        m--;//convert size to index
        n--;
        while (m >= 0 && n >= 0){
            if (nums1[m] > nums2[n]){
                nums1[last] = nums1[m];
                last--;
                m--;
            }else{
                nums1[last] = nums2[n];
                last--;
                n--;
            }
        }
        
        for (int i = 0; i <= n; i++){
            nums1[i] = nums2[i];
        }
    }
}
