public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        int tmp = 1;
        for (int i = 0; i <= rowIndex; i++){
            row.add(1);
            for (int j = 1; j < i; j++){
                tmp = row.set(j, tmp+row.get(j));
            }
        }
        return row;
    }
}