public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)){
            set.add(n);
            n = squareSum(n);
            if (n == 1){
                return true;
            }
        }
        return n == 1;
    }
    
    private int squareSum(int n){
        int sum = 0;
        while (n != 0){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}