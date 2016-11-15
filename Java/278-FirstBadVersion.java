/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
      
//Attention to overflow!!!
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return (isBadVersion(1) ? 1 : 2);
        int start = 0, end = n;
        while (end - start > 1){
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)){
                end = mid;
            }else{
                start = mid;
            }
        }
        return end;
    }
}