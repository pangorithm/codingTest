import java.util.*;

class Solution {
    static HashSet<HashSet<String>> answerSet;
    static HashMap<String, HashSet<String>> bannedIdMap;
    
    public int solution(String[] user_id, String[] banned_id) {
        bannedIdMap = new HashMap<>();
        for(String banned : banned_id){
            if(!bannedIdMap.containsKey(banned)){
                HashSet<String> set = new HashSet<>();
                for(String user : user_id){
                    if(user.length() == banned.length() && canTrance(user, banned)){
                        set.add(user);
                    }
                }
                bannedIdMap.put(banned, set);
            }
        }
        // System.out.println(bannedIdMap);
        
        answerSet = new HashSet<HashSet<String>>();
        search(new HashSet<String>(), 0, banned_id);
        
        return answerSet.size();
    }
    
    void search(HashSet<String> userSet, int dept, String[] banned_id){
        if(dept == banned_id.length){
            if(userSet.size() == dept){
                // System.out.println(userSet);
                answerSet.add(userSet);
            }            
        } else {
            HashSet<String> set = bannedIdMap.get(banned_id[dept]);
            String[] arr = set.toArray(new String[set.size()]);
            for(String user : arr){
                if(!userSet.contains(user)){
                    HashSet<String> newUserSet = new HashSet<>(userSet);
                    newUserSet.add(user);
                    search(newUserSet, dept + 1, banned_id);
                }                
            }
        }
    }
    
    boolean canTrance(String id1, String id2){
        char[] carr1 = id1.toCharArray();
        char[] carr2 = id2.toCharArray();
        
        for(int i = 0; i < carr1.length; i++){
            if(carr1[i] != '*' && carr2[i] != '*' && carr1[i] != carr2[i]){
                return false;
            }
        }
        return true;
    }
}