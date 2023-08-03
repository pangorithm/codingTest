import java.util.*;

class Solution {
    static ArrayList<String> answerList;
    
    public String[] solution(String[][] tickets) {
        answerList = new ArrayList<String>();
        
        search("ICN", "ICN", 0, new boolean[tickets.length], tickets);
        
        Collections.sort(answerList);
        return answerList.get(0).split(" ");
    }
    
    void search(String from, String route, int dept, boolean[] visits, String[][] tickets){
        if(dept == visits.length){
            answerList.add(route);
        }
        for(int i = 0; i < tickets.length; i++){
            if(!visits[i] && from.equals(tickets[i][0])){
                boolean[] nextVisits = Arrays.copyOf(visits, visits.length);
                nextVisits[i] = true;
                search(tickets[i][1], route + " " + tickets[i][1], dept + 1, nextVisits, tickets);
            }
        }
    }
    
}