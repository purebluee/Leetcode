public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0){
            return false;
        }
        if ( num == 1){
            return true;
        }
        long left = 1, right = num;
        while (left <= right){
            long mid = left + (right - left) / 2;
            long mid2 = mid * mid;
            if (mid2 > num){
                right = mid - 1;
            }else if (mid2 < num){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}