public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        String ver1;
        String ver2;
        
        for (int i = 0; i < Math.max(v1.length, v2.length); i ++){
            if (i >= v2.length)  {
                ver1 = v1[i];
                ver2 = "0";
            }else if (i >= v1.length){
                ver1 = "0";
                ver2 = v2[i];
            }else{
                ver1 = v1[i];
                ver2 = v2[i];
            }
            System.out.println(ver1 + " : " + ver2);
            if (Integer.parseInt(ver1) < Integer.parseInt(ver2)){
                return -1;
            }else if (Integer.parseInt(ver1) > Integer.parseInt(ver2)){
                return 1;
            }else if (Integer.parseInt(ver1) == Integer.parseInt(ver2)){
                continue;
            }
        }
        return 0;
    }
}