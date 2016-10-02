public class Solution {
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