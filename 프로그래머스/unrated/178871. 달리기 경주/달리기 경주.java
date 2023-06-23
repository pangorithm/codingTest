import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int rank = 0; rank < players.length; rank++){
            map.put(players[rank], rank);
        }
        for(String name : callings){
            int rank = map.get(name);
            map.put(players[rank - 1], rank);
            map.put(name, rank - 1);
            players[rank] = players[rank - 1];
            players[rank - 1] = name;             
        }
        return players;
    }
}