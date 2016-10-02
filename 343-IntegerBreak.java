/*


The optimal product should contain no more than two 2

I think a good way to explain why we need to use 3 as much as possible is: 
assume a breakdown has 3 twos, those 3 twos have a product of 8 which is 
less than the product of 2 threes(we can improve it that way). So we can 
prove the breakdown can have at most 2 twos. Thus, the conclusion is we 
should use 3 as much as possible.

*/
public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int product = 1;
        while (n > 4){
            product *= 3;
            n -= 3;
        }
        product *= n;
        return product;
    }
}