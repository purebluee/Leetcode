public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            n--;
            int curr = n % 26;
            char currLetter = (char)('A' + curr);
            sb.insert(0, currLetter);
            n /= 26;
            
        }
        return sb.toString();
    }
}