public class Solution{
    public String getHint(String secret, String guess){
        int[] s = new int[10];
        int[] g = new int[10];
        int a = 0, b = 0;
        for (int i = 0; i < secret.length(); i++){
            if (secret.charAt(i) == guess.charAt(i)){
                a++;
            }else{
                s[secret.charAt(i) - '0'] ++;
                g[guess.charAt(i) - '0'] ++;
            }
        }
        for (int i = 0; i < 10; i++){
            b += Math.min(s[i], g[i]);
        }
        return a+"A"+b+"B";
    }
}

/*
public class Solution {
    public String getHint(String secret, String guess) {
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int a = 0, b = 0;
        int[] count = new int[10];
        for(int i = 0; i < s.length; i++){
            if (s[i] == g[i])   a++;
            else{
                if (count[s[i]-'0'] > 0){
                    b++;
                    count[s[i]-'0']++;
                }
                else{
                    count[s[i]-'0']++;
                }
            }
        }
        return a+"A"+b+"B";
    }
}
*/