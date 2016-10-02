//I try to encode a string like len#string this way, for example {"", "abc", "ab", "2#"}, it will
//encode it to "0#3#abc2#ab2#2#", then decode it by reading the length first, followed by reading 
//the string with the length.
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null)
            return null;
        if (strs.size() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++){
            sb.append(strs.get(i).length()).append("#").append(strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s == null)
            return null;
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()){
            int seperatorIndex = s.indexOf("#", i);
            int num = Integer.parseInt(s.substring(i, seperatorIndex));
            res.add(s.substring(seperatorIndex + 1, seperatorIndex + num + 1));
            i = seperatorIndex + num + 1;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));