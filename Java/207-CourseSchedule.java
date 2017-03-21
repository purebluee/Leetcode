public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0){
            return true; 
        }
        
        // create a list to represent the courses
        List<List<Integer>> courses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            courses.add(new ArrayList<>());
        }
        
        //create the dependency graph
        for (int i = 0; i < prerequisites.length; i++){
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] visited = new int[numCourses];
        
        //dfs visit each course
        for (int i = 0; i < numCourses; i++){
            if (!dfs(i, courses, visited)) 
                return false;
        }
        return true;
    }
    
    private boolean dfs(int course, List<List<Integer>> courses, int[] visited){
        visited[course] = 1; //mark visited
        List<Integer> eligibleCourses = courses.get(course); //get its children
        
        //dfs its children
        for (int i = 0; i < eligibleCourses.size(); i++){
            int eligibleCourse = eligibleCourses.get(i).intValue();
            
            if (visited[eligibleCourse] == 1)
                return false;
            if (visited[eligibleCourse] == 0){
                if (!dfs(eligibleCourse, courses, visited))
                    return false;
            }
        }
        
        visited[course] = 2;// mark it done visiting
        return true;
    }
}

//more generalized solution (TLE)
//2, [[1,0],[0,1]]
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0){
            return true; 
        }
        Map<Integer, List<Integer>> edgeList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!edgeList.containsKey(prerequisites[i][1])) {
                edgeList.put(prerequisites[i][1], new ArrayList<Integer>());
            } 
            edgeList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(edgeList, visited, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> edgeList, Set<Integer> visited, int n) {
        if (visited.contains(n)) {
            return false;
        } else {
            visited.add(n);
        }
        if (edgeList.get(n) != null) {
            for (int i : edgeList.get(n)) {
                if (!dfs(edgeList, visited, i)) {
                    return false;
                }
            }
        }
        visited.remove(n);
        return true;
    }
}