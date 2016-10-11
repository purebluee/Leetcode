
public class Solution {
    public int lengthOfLastWord(String s) {
        //if (s.length() == 0)    return 0;
        char[] arr = s.toCharArray();
        int index = arr.length - 1;
        int count = 0;
        while (index > 0 && arr[index] == ' '){
            index--;
        }
        for (; index >= 0; index --){
            while (index >= 0 && arr[index] != ' '){
                count += 1;
                index -= 1;
            }
            if (count > 0)
                return count;
            index -= 1;
        }
        return 0;
    }
}
