public class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    // Add the number to an internal data structure.
    public void add(int number) {
        if (!map.containsKey(number)){
            map.put(number, 1);
            list.add(number);
        }else{
            map.put(number, map.get(number) + 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        if (list.isEmpty()){
            return false;
        }
        for (int i = 0; i < list.size(); i++){
            if (value - list.get(i) == list.get(i) && map.get(list.get(i)) > 1){
                return true;
            }
            if (value - list.get(i) != list.get(i) && map.containsKey(value - list.get(i))){
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);