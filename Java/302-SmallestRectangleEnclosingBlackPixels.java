//DFS
public class Solution {
    private int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0) return 0;
        dfs(image, x, y);
        return(maxX - minX + 1) * (maxY - minY + 1);
    }
    private void dfs(char[][] image, int x, int y){
        int m = image.length, n = image[0].length;
        if(x < 0 || y < 0 || x >= m || y >= n || image[x][y] == '0') return;
        image[x][y] = '0';
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y - 1);
        dfs(image, x, y + 1);
    }
    
}

//Binary search
public int minArea(char[][] image, int x, int y) {
    int left = leftmost(image, 0, y, true);
    int right = rightmost(image, y, image[0].length - 1, true);
    int top = leftmost(image, 0, x, false);
    int bottom = rightmost(image, x, image.length - 1, false);
    return (right - left + 1) * (bottom - top + 1);
}

int leftmost(char[][] image, int min, int max, boolean horizontal) {
    int l = min, r = max;
    while (l < r) {
        int mid = l + (r - l) / 2;
        if (!hasBlack(image, mid, horizontal)) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    return l;
}

int rightmost(char[][] image, int min, int max, boolean horizontal) {
    int l = min, r = max;
    while (l < r) {
        int mid = l + (r - l + 1) / 2;
        if (!hasBlack(image, mid, horizontal)) {
            r = mid - 1;
        } else {
            l = mid;
        }
    }
    return r;
}

boolean hasBlack(char[][] image, int mid, boolean horizontal) {
    if (horizontal) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][mid] == '1') {
                return true;
            }
        }
    } else {
        for (int j = 0; j < image[0].length; j++) {
            if (image[mid][j] == '1') {
                return true;
            }
        }
    }
    return false;
}