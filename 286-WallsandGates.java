//Iterative:
public class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }
    }
}

//dumber iterative
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        int inf = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                if (row - 1  >= 0 && rooms[row-1][col] == inf){
                    rooms[row-1][col] = rooms[row][col] + 1;
                    q.offer(new int[]{row-1, col});
                }
                if (row + 1 < m && rooms[row+1][col] == inf){
                    rooms[row+1][col] = rooms[row][col] + 1;
                    q.offer(new int[]{row+1, col});
                }
                if (col - 1 >= 0 && rooms[row][col-1] == inf){
                    rooms[row][col-1] = rooms[row][col] + 1;
                    q.offer(new int[]{row, col-1});
                }
                if (col + 1 < n && rooms[row][col+1] == inf){
                    rooms[row][col+1] = rooms[row][col] + 1;
                    q.offer(new int[]{row, col + 1});
                }
            }
        }
    }
}

//recursion
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == 0){
                    fill(rooms, i, j, 0);
                }
            }
        }
    }
    
    private void fill(int[][] rooms, int i, int j, int distance){
        int m = rooms.length;
        int n = rooms[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] < distance){
            return;
        }
        rooms[i][j] = distance;
        
        fill(rooms, i - 1, j, distance + 1);
        fill(rooms, i + 1, j, distance + 1);
        fill(rooms, i, j + 1, distance + 1);
        fill(rooms, i, j - 1, distance + 1);
    }
}