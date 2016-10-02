public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        if (s.length() == 0 || s == null){
            return new ArrayList(repeated);
        }
        for (int i = 0; i < s.length() - 9; i++){
            String ten = s.substring(i, i+10);
            if (!seen.add(ten)){
                repeated.add(ten);
            }
        }
        return new ArrayList<>(repeated);
    }
}