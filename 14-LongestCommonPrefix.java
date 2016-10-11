/*
I think there are two (straightforward) solutions:

    "Horizontal matching (over strings)". Pick up the first string and compare it with the rest. Return the minimum prefix found among all comparisons.
    The first one is apparently not very optimal. Imagine only the last string is different from all others. You would have wasted so much time comparing the previous ones.
    "Vertical matching (over characters)". Compare the characters between all strings from left to right. Stop whenever a mismatch is found.
    The question is equivalent to: what is the fastest way to fail? It seems the second one is the only answer.
Below second sol:
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++){
                if (strs[j].length() == i || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}