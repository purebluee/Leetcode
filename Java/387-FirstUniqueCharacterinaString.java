//two pass
public class Solution {
    public int firstUniqChar(String s) {
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++){
            dict[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++){
            if (dict[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}

//one pass
//Actually one string scan + one frequency array scan.
public class Solution {
    public int firstUniqChar(String s) {
        char[] schar = s.toCharArray();
        int result = schar.length;
        int[] seen = new int[26];
        //-1 => not visited
        //-2 => repeating
        //>=0 => appear once, value is index
        Arrays.fill(seen, -1);
        for(int i = 0; i < schar.length; i++) {
            int index = schar[i]-'a';
            if(seen[index] == -1) seen[index] = i;
            else if(seen[index] >= 0) seen[index] = -2;
        }
        for(int i = 0; i < 26; i++) {
            if(seen[i] >= 0) result = Math.min(result, seen[i]);
        }
        return result == schar.length?-1:result;
    }
}