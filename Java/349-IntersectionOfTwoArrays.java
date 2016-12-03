public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++){
            if (!set.contains(nums1[i])){
                set.add(nums1[i]);
            }
        }
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++){
            if (set.contains(nums2[i])){
                r.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] res = new int[r.size()];
        for (int i = 0; i < r.size(); i++){
            res[i] = r.get(i);
        }
        return res;
    }
}