//I try to encode a string like len#string this way, for example {"", "abc", "ab", "2#"}, it will
//encode it to "0#3#abc2#ab2#2#", then decode it by reading the length first, followed by reading 
//the string with the length.
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null){
            return null;
        }
        if (strs.size() == 0){
            return new String();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++){
            int len = strs.get(i).length();
            sb.append(len + "#" + strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if (s == null){
            return null;
        }
        if (s.length() == 0){
            return res;
        }
        int curr = 0;
        while (curr < s.length()){
            int separatorIndex = s.indexOf("#", curr);
            int len = Integer.parseInt(s.substring(curr, separatorIndex));
            curr = separatorIndex + 1;
            String currStr = s.substring(curr, curr + len);
            res.add(currStr);
            curr += len;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));