/* might not match the solution below
By considering the word squares as a symmetric matrix, my idea is to go through the top right triangular matrix in left-to-right and then down order.
For example, with the case of ["area","lead","wall","lady","ball"] where length = 4,
we start with 4 empty string
""
""
""
""
Next, [0,0] , "a","b", "l", "w" can be placed, we start with "a"
"a"
""
""
""
[0,1] go right, "r" can be placed after "a", but no words start with "r" at [1,0], so this DFS ends.
"ar"
""
""
""
Now, start with "b" at [0,0]
"b"
""
""
""
We can have "ba" at [0,1] and there is a word start with "a"
"ba"
"a"
""
""
Next
"bal"
"a"
"l"
""
Next
"ball"
"a"
"l"
"l"
When finish the first row, go down to next row and start at [1,1]
"ball"
"ar"
"l"
"l"
..... so on and so forth until reaching [4,4]
*/
public class Solution {
    TrieNode root = new TrieNode();
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if(words.length == 0) return ans;
        buildTrie(words);
        int length = words[0].length();
        findSquare(ans, length, new ArrayList<>());
        return ans;
    }
    
    private void findSquare(List<List<String>> ans, int length, List<String> temp) {
        if(temp.size() == length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        int index = temp.size();
        StringBuilder sb = new StringBuilder();
        for(String s : temp) {
            sb.append(s.charAt(index));
        }
        String s = sb.toString();
        TrieNode node = root;
        for(int i = 0; i < s.length(); i++) {
            if(node.next[s.charAt(i) - 'a'] != null) {
                node = node.next[s.charAt(i) - 'a'];
            } else {
                node = null;
                break;
            }
        }
        if(node != null) {
            for(String next : node.words) {
                temp.add(next);
                findSquare(ans, length, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private void buildTrie(String[] words) {
        for(String word : words) {
            TrieNode node = root;
            char[] array = word.toCharArray();
            for(char c : array) {
                node.words.add(word);
                if(node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.words.add(word);
        }
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        List<String> words = new ArrayList<>();
    }
}