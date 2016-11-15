public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        List<Integer> l = new ArrayList<>();
        int idx2 = 0, idx3 = 0, idx5 = 0;
        l.add(1);
        for (int i = 1; i < n; i++){
            int min = Math.min(Math.min(l.get(idx2) * 2, l.get(idx3) * 3), l.get(idx5) * 5);
            l.add(min);
            if (min == l.get(idx2) * 2)
                idx2++;
            if (min == l.get(idx3) * 3)
                idx3++;
            if (min == l.get(idx5) * 5)
                idx5++;
        }
        return l.get(l.size() - 1);
    }
}