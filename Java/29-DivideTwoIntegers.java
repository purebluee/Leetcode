public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        //use long to avoid overflow
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        
        if (ldividend == 0 || (ldividend < divisor))    return 0;
        if (divisor == 0)   return Integer.MAX_VALUE;
        
        long lans = ldivide(ldividend, ldivisor);
        int res = 0;
        if (lans > Integer.MAX_VALUE){
            res = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else{
            res = (int)(sign * lans);
        }
        return res;
    }
    
    private long ldivide (long ldividend, long ldivisor){
        //Recursion exist condition
        if (ldividend < ldivisor)   return 0;
        //Find the largest multiple so that (divisor * multiple <= dividend),
        //we are moving with stride 1, 2, 4, 6, 16...2^n for fast search.
        //Similar to binary search
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) < ldividend){
            sum += sum;
            multiple += multiple;
        }
        //look for additional value for multiplication the reminder (dividend - sum) recursively
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}