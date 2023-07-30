import java.util.*;

class Solution {
    static HashSet<HashSet<String>> answerSet;
    
    public int solution(String[] user_id, String[] banned_id) {
        answerSet = new HashSet<HashSet<String>>();
        search(new HashSet<String>(), 0, user_id, banned_id);
        
        return answerSet.size();
    }
    
    void search(HashSet<String> userSet, int dept, String[] user_id, String[] banned_id){
        if(dept == banned_id.length){
            if(userSet.size() == dept){
                // System.out.println(userSet);
                answerSet.add(userSet);
            }            
        } else {
            for(String user : user_id){
                if(user.length() == banned_id[dept].length() 
                   && canTrance(user, banned_id[dept])
                   && !userSet.contains(user)){
                    HashSet<String> newUserSet = new HashSet<>(userSet);
                    newUserSet.add(user);
                    search(newUserSet, dept + 1, user_id, banned_id);
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