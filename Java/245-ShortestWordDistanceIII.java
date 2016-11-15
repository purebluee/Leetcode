public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words.length == 0 || words == null)
            return 0;
        int len = words.length;
        int min = len;
        int p1 = -words.length, p2 = words.length;
        for (int i = 0; i < len; i++){
            if (!word1.equals(word2)){
                if (words[i].equals(word1))
                    p1 = i;
                if (words[i].equals(word2))
                    p2 = i;
                min = Math.min(min, Math.abs(p1 - p2));
            }else{
                if (words[i].equals(word1)){
                    min = Math.min(min, Math.abs(p2 - i));
                    p2 = i;
                }
            }
            
        }
        return min;
    }
}