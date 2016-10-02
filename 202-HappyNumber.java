public class Solution {
    public boolean isHappy(int n) {
        boolean[] exist = new boolean[1000];
        while (true){
            if (n == 1) return true;
            int sum = 0;
            while(n > 0){
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            if(exist[sum] == true)  return false;
            exist[sum] = true;
        }
    }
}