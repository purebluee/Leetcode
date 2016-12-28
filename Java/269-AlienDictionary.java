public class Solution {
    private int aLen = 26;                  // len of alphabet
    public String alienOrder(String[] words) {
        // https://discuss.leetcode.com/topic/32900/easiest-java-bfs-solution/2
        // Toposort problem
        // BUILD GRAPH:
        ArrayList<HashSet<Integer>> neighbours = new ArrayList<>(aLen);       // adjacency list of nodes
        int[] degree = new int[aLen];      // degrees incoming
        buildGraph(words, degree, neighbours);
        
        // TOPOLOGICAL SORT:
        // The starting frontier is all characters with inbound edges of 0 since
        // the are earliest in the alien alphabet. Reduce all neighbours'
        // inbound edges by 1 since now we can reach to them next. If any of them
        // turn to 0, then add those to the frontier and repeat. Store the polled
        // values with inbound edges 0 in order that they come out. This is the
        // lexicographical ordering of the alien alphabet.
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = (int) q.poll();
            sb.append((char) (curr + 'a'));
            for (Integer i : neighbours.get(curr)) {
                degree[i] = degree[i] - 1;
                if (degree[i] == 0) q.add(i);
            }
        }
        
        // check if there are any characters to which we could not resolve.
        // if there exists any with deg > 0, then there was not substantial
        // data to decide where this character belonged
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] > 0) return "";
        }
        
        return sb.toString();

    }
    
    /* Step 1: build the graph.
    * For each character, count how many inbound edges there are,
    * where an inbound edge is defined s.t. for words w1 and w2,
    * where charAt(w1) != charAt(w2), w1 -> w2. We also keep a 
    * running list of neighbours for each character. */
    public void buildGraph(String[] words, int[] deg, ArrayList<HashSet<Integer>> n) {
        // init the neighbours array
        for (int i = 0; i < aLen; i++) n.add(new HashSet<Integer>());
        for (int i = 0; i < deg.length; i++) {
            deg[i] = -1;                // representing as not in the array
        }
        
        for (int i = 0; i < words.length; i++) {
            // build the indegrees for each character
            String currString = words[i];
            for (int j = 0; j < currString.length(); j++) {
                int currChar = currString.charAt(j) - 'a';
                if (deg[currChar] < 0) deg[currChar] = 0;           // set this character as seen if not yet
            }
        }
            
        for (int i = 1; i < words.length; i++) {
            // we want to compare pairs of words at idx words[i] and words[i+1]
            // for every letter in words[i], if we see that charAt(j_i) != charAt(j_i+1),
            // then we know that there is an inbound edge pointing from charAt(j_i) -> charAt(j_i+1),
            // since the char from w_i should come before w_i+1 lexiographically.
            String w1 = words[i-1];
            String w2 = words[i];
            
            if (w1.length() > w2.length()) {
                // corner case s.t. we might have "wrtkj" come before "wrt",
               // but this must never be the case
                if (w1.substring(0, w2.length()).equals(w2)) {
                    Arrays.fill(deg, 5);
                    return;
                }
            }
            
            for (int k = 0; k < Math.min(w1.length(), w2.length()); k++) {
                int c1 = w1.charAt(k) - 'a';
                int c2 = w2.charAt(k) - 'a';

                if (c1 != c2) {
                    // c1 -> c2 must be true
                    if (!n.get(c1).contains(c2)) {
                        // does c1 point to c2 already? 
                        // don't want to double count or produce a cycle
                        n.get(c1).add(c2);
                        deg[c2] = deg[c2] + 1;        // update the inbound for c2
                    }
                    break;                              // insubstantial evidence past this mismatch

                }
            }
        }
    }
}
