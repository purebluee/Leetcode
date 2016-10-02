/*
Memorizing all the positions that each string appears. Put it into a array and store <String, List<Integer>> as a pair in the hash map. When we need to find the shortest path of two string, just get the two list of these two string. Use two pointers and scan the two lists at the same time. When any pointer reach the end. Stop the loop. When we found out that the first position is greater than the second one. We add one to the second pointer. Else, add to the first pointer. This idea is like always keep minimum difference between the two position and move the two pointers.


*/

public class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++){
            String temp = words[i];
            if (map.containsKey(temp)){
                map.get(temp).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int size1 = list1.size(), size2 = list2.size();
        int i = 0, j = 0;
        while (i < size1 && j < size2){
            int w1 = list1.get(i), w2 = list2.get(j);
            if (w1 < w2){
                min = Math.min(min, Math.abs(w1 - w2));
                i++;
            }else{
                min = Math.min(min, Math.abs(w1 - w2));
                j++;
            }
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");