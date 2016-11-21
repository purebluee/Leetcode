//brute force
//O(n^3)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}

/*
In the naive approaches, we repeatedly check a substring to see if it has duplicate character. But it is unnecessary. If a substring s_{ij}s
​ij
​​  from index ii to j - 1j−1 is already checked to have no duplicate characters. We only need to check if s[j]s[j] is already in the substring s_{ij}s
​ij
​​ .

To check if a character is already in the substring, we can scan the substring, which leads to an O(n^2)O(n
​2
​​ ) algorithm. But we can do better.

By using HashSet as a sliding window, checking if a character in the current can be done in O(1)O(1).

A sliding window is an abstract concept commonly used in array/string problems. A window is a range of elements in the array/string which usually 
defined by the start and end indices, i.e. [i, j)[i,j) (left-closed, right-open). A sliding window is a window "slides" its two boundaries to the 
certain direction. For example, if we slide [i, j)[i,j) to the right by 11 element, then it becomes [i+1, j+1)[i+1,j+1) (left-closed, right-open).

Back to our problem. We use HashSet to store the characters in current window [i, j)[i,j) (j = ij=i initially). Then we slide the index jj to the right. 
If it is not in the HashSet, we slide jj further. Doing so until s[j] is already in the HashSet. At this point, we found the maximum size of substrings without 
duplicate characters start with index ii. If we do this for all ii, we get our answer.
*/


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        } 
        int i = 0, j = 0, len = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (i < len){
            if (!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
                max = Math.max(max, set.size());
            }else{
                set.remove(s.charAt(j));
                j++;
            }
        }
        return max;
    }
}

//harder to understand
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; j < n; j++){
            if (hm.containsKey(s.charAt(i))){
                i = Math.max(hm.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            hm.put(s.charAt(j), j+1);
        }
        return ans;
    }
}