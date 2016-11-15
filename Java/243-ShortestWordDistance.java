public class Solution {
    //brute force, O(n^2)
    public int shortestDistanceBF(String[] words, String word1, String word2) {
        int minDistance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        minDistance = Math.min(minDistance, Math.abs(i - j));
                    }
                }
            }
        }
        return minDistance;
    }

    //two pointers, one pass O(n)
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words.length == 0 || words == null)
            return 0;
        int len = words.length;
        int res = len;
        int p1 = -len, p2 = -len;
        for (int i = 0; i < len; i++){
            if (words[i].equals(word1)){
                p1 = i;
                res = Math.min(res, Math.abs(i - p2));//also works without abs
            }else if (words[i].equals(word2)){
                p2 = i;
                res = Math.min(res, Math.abs(i - p1));
            }
        }
        return res;
    }
}