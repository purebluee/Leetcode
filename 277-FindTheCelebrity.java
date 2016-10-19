/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
//The first pass is to pick out the candidate. 
//If candidate knows i, then switch candidate. 
//The second pass is to check whether the candidate is real.

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 0)
            return -1;
        if (n == 1)
            return 0;
        int cand = 0, curr = 1;
        while (cand < n && curr < n){
            if (knows(cand, curr)){
                cand = curr;
            }
            curr++;
        }
        for (int i = 0; i < n; i++){
            if (!knows(i, cand) && i != cand){
                return -1;
            }
            if (knows(cand, i) && i != cand){
                return -1;
            }
        }
        return cand;
    }
}