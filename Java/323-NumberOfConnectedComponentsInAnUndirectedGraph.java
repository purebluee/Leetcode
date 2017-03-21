//BFS
public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1)
            return n;
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        Map<Integer, List<Integer>> edgeList = new HashMap<>();

        for (int[] edge : edges) {
            //two directions!
            if (!edgeList.containsKey(edge[0])) {
                edgeList.put(edge[0], new ArrayList<Integer>());
            }
            if (!edgeList.containsKey(edge[1])) {
                edgeList.put(edge[1], new ArrayList<Integer>());
            }
            edgeList.get(edge[0]).add(edge[1]);
            edgeList.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, visited, edgeList);
                count++;
            }
        }
        return count;
    }

    private void dfs(int currVertex, Set<Integer> visited, Map<Integer, List<Integer>> edgeList) {
        //wrong!!
        //if (visited.contains(n)) {
        //    return;
        //}
        if (edgeList.get(currVertex) != null) {
            for (int vertex : edgeList.get(currVertex)) {
                if (!visited.contains(vertex)) {
                    visited.add(vertex);
                    dfs(vertex, visited, edgeList);
                }
            }
        }
    }
}

//BFS
public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1)
            return n;
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        Map<Integer, List<Integer>> edgeList = new HashMap<>();

        for (int[] edge : edges) {
            //two directions!
            if (!edgeList.containsKey(edge[0])) {
                edgeList.put(edge[0], new ArrayList<Integer>());
            }
            if (!edgeList.containsKey(edge[1])) {
                edgeList.put(edge[1], new ArrayList<Integer>());
            }
            edgeList.get(edge[0]).add(edge[1]);
            edgeList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();

        //wrong: for (int i : edgeList.keySet()) {
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                queue.offer(i);
                visited.add(i);
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    //System.out.println(curr);
                    //System.out.println(edgeList.get(curr));
                    if (edgeList.get(curr) != null) {
                        for (int next : edgeList.get(curr)) {
                            if (!visited.contains(next)) {
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
