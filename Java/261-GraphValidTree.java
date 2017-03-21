public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 1)
            return true;
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> edgeList = new HashMap<>();
        for (int[] edge : edges) {
            if (!edgeList.containsKey(edge[0])) {
                edgeList.put(edge[0], new ArrayList<>());
            }
            if (!edgeList.containsKey(edge[1])) {
                edgeList.put(edge[1], new ArrayList<>());
            }
            edgeList.get(edge[0]).add(edge[1]);
            edgeList.get(edge[1]).add(edge[0]);
        }
        if (!dfs(0, -1, edgeList, visited)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int v, int parent, Map<Integer, List<Integer>> edgeList, Set<Integer> visited) {
        visited.add(v);
        if (edgeList.get(v) == null) {
            return false;
        }
        for (int i : edgeList.get(v)) {
            if (i == parent) {
                continue;
            }
            if (visited.contains(i) || !dfs(i, v, edgeList, visited)) {
                return false;
            }
        }
        return true;
    }
}
