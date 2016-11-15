public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0){
            return res;
        }
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++){
            List<Integer> diff = new ArrayList<>();
            if (strings[i].length() > 1){
                for (int j = 1; j < strings[i].length(); j++){
                    int offset = strings[i].charAt(j) - strings[i].charAt(j - 1);
                    if (offset < 0){
                        offset += 26;
                    }
                    diff.add(offset);
                }
            }
            if (!map.containsKey(diff)){
                List<String> tmp = new ArrayList<>();
                tmp.add(strings[i]);
                map.put(diff, tmp);
            }else{
                List<String> tmp = map.get(diff);
                tmp.add(strings[i]);
                map.put(diff, tmp);
            }
        }
        return new ArrayList<>(map.values());
    }
}