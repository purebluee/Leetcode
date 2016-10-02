public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C-A)*(D-B) + (G-E)*(H-F);
        if ((B >= H) || (E >= C) || (A >= G) || (F >= D))   return total;
        int dx = Math.min(C, G) - Math.max(A, E);
        int dy = Math.min(D, H) - Math.max(B, F);
        return total - dx * dy;
    }
}