public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();//must use hashset, not list! subseq might be the same!
        if (s.length() < 10){
            return new ArrayList<>(res);
        }
        for (int i = 0; i < s.length() - 9; i++){//length - 9  substring excludes last element!
            String seq = s.substring(i, i + 10);
            if (!set.contains(seq)){
                set.add(seq);
            }else{
                res.add(seq);
            }
        }
        return new ArrayList<>(res);
    }
}