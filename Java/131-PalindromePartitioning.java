public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        if (s.length() == 0){
            return res;
        }
        trackback(s, 0, tmp, res);
        return res;
    }
    
    private void trackback(String s, int pos, List<String> tmp, List<List<String>> res){
        if (pos == s.length())  
            res.add(new ArrayList<String>(tmp));
        else{
            for (int i = pos; i < s.length(); i++){
                if (isPal(s, pos, i)){
                    tmp.add(s.substring(pos, i+1));
                    trackback(s, i+1, tmp, res);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
    
    private boolean isPal(String s, int low, int high){
        while (low < high){
            if (s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}