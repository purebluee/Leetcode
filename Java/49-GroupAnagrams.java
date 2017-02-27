public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)   
            return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs){
            char[] ca = string.toCharArray();
            Arrays.sort(ca);
            String keyString = String.valueOf(ca);
            if (!map.containsKey(keyString)){
                map.put(keyString, new ArrayList<String>());
            }
            map.get(keyString).add(string);
        }
        return new ArrayList<List<String>>(map.values());
    }
}