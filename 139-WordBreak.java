public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] breakable = new boolean[s.length()+1];
        breakable[0] = true;
        
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                if (breakable[j] && wordDict.contains(s.substring(j, i))){
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length()];
    }
}

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0 || wordDict == null || wordDict.size() == 0){
            return false;
        }
        boolean[] breakable = new boolean[s.length()+1];
        breakable[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j <= i && !breakable[i]; j++){
                breakable[i] = wordDict.contains(s.substring(j, i)) && breakable[j];
            }
        }
        return breakable[s.length()];
    }
}