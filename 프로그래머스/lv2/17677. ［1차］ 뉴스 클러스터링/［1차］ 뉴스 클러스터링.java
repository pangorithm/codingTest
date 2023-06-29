import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashSet<String> u = new HashSet<>();
        for(int i = 0; i < str1.length() - 1; i++){
            String temp = str1.substring(i, i + 2);
            if(temp.matches(".*[^a-z].*")){
                continue;
            }
            map1.put(temp, map1.getOrDefault(temp, 0) + 1);
            u.add(temp);
        // System.out.println(temp);
        }
        // System.out.println("-----------");
        for(int i = 0; i < str2.length() - 1; i++){
            String temp = str2.substring(i, i + 2);
            if(temp.matches(".*[^a-z].*")){
                continue;
            }
            map2.put(temp, map2.getOrDefault(temp, 0) + 1);
            u.add(temp);
        // System.out.println(temp);
        }
        
        if(u.size() == 0){
            return 65536;
        }
        int uSize = 0;
        int nSize = 0;
        
        String[] elements = u.toArray(new String[u.size()]);
        for(String e : elements){
            uSize += Math.max(map1.getOrDefault(e, 0), map2.getOrDefault(e, 0));
            nSize += Math.min(map1.getOrDefault(e, 0), map2.getOrDefault(e, 0));                
        }
                        
        return (int) ((double) nSize / (double) uSize * 65536);
    }
}