public class Solution {
    public int countPrimes(int n) {
        int counter = 0;
        if (n==0||n==1) return 0;
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        
        for (int i = 2; i * i < n; i++){
            if (!notPrime[i]){
                for (int j = 2; i * j < n; j++){
                    notPrime[i*j] = true;//Attention!!! [i*j]
                }
            }
        }
        for (int i = 2; i < notPrime.length; i++){
            if (!notPrime[i])
                counter++;
        }
        return counter;
    }
}