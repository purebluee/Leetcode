/*
The key point of this problem is to ignore half part of A and B each 
step recursively by comparing the median of remaining A and B:

if (aMid < bMid) Keep [aRight + bLeft]

else Keep [bRight + aLeft]
As the following: time=O(log(m + n))
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.f;
        }
         
        int n1 = nums1.length;
        int n2 = nums2.length;
         
        if ((n1 + n2) % 2 == 1) {
            return findMedianHelper(nums1, nums2, (n1 + n2) / 2 + 1);
        } else {
            return (findMedianHelper(nums1, nums2, (n1 + n2) / 2) + findMedianHelper(nums1, nums2, (n1 + n2) / 2 + 1)) / 2;
        }
    }
     
    private double findMedianHelper(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0) {
            return nums2[k - 1];
        }
         
        if (nums2 == null || nums2.length == 0) {
            return nums1[k - 1];
        }
         
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }
         
        int n1 = nums1.length;
        int n2 = nums2.length;
         
        if (nums1[n1 / 2] > nums2[n2 / 2]) {
            if ((n1 / 2 + n2 / 2 + 1) >= k) {
                return findMedianHelper(Arrays.copyOfRange(nums1, 0, n1 / 2), nums2, k);
            } else {
                return findMedianHelper(nums1, Arrays.copyOfRange(nums2, n2 / 2 + 1, n2), k - (n2 / 2 + 1));
            }
        } else {
            if ((n1 / 2 + n2 / 2 + 1) >= k) {
                return findMedianHelper(nums1, Arrays.copyOfRange(nums2, 0, n2 / 2), k);
            } else {
                return findMedianHelper(Arrays.copyOfRange(nums1, n1 / 2 + 1, n1), nums2, k - (n1 / 2 + 1));
            }
        }
    }
}

//merge O(m+n)
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int digits = nums1.length + nums2.length;
        int[] indexs = new int[2];
        int[] values = new int[2];
        if (digits%2 == 0) {
            indexs[0] = digits/2 - 1;
            indexs[1] = digits/2;
        }else {
            indexs[0] = digits/2;
            indexs[1] = digits/2;
        }

        
        int t = 0;
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            while (i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) {
                t++; i++;
                if (t - 1 == indexs[0]) {
                    values[0] = nums1[i-1];
                }      
                if (t - 1 == indexs[1]) {
                    values[1] = nums1[i-1];
                    return (values[0] + values[1])/2.0;
                }                  
            }
            
            while (i < nums1.length && j < nums2.length && nums1[i] >= nums2[j]) {
                t++; j++;
                if (t - 1 == indexs[0]) {
                    values[0] = nums2[j-1];
                }      
                if (t - 1 == indexs[1]) {
                    values[1] = nums2[j-1];
                    return (values[0] + values[1])/2.0;
                }               
            }
        }
        
        while (i < nums1.length){
            t++; i++;
            if (t - 1 == indexs[0]) {
                values[0] = nums1[i-1];
            }      
            if (t - 1 == indexs[1]) {
                values[1] = nums1[i-1];
                return (values[0] + values[1])/2.0;
            }          
        }
        
        while (j < nums2.length){
            t++; j++;
            if (t - 1 == indexs[0]) {
                values[0] = nums2[j-1];
            }      
            if (t - 1 == indexs[1]) {
                values[1] = nums2[j-1];
                return (values[0] + values[1])/2.0;
            }           
        }    

        return (values[0] + values[1])/2.0;
        
    }
}
