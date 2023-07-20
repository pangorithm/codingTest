import java.util.*;

class Solution {
    static HashMap<String, ArrayList<Integer>> scoreMap = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        String[][] splitedInfo = new String[info.length][5];
        for(int i = 0; i < info.length; i++){
            splitedInfo[i] = info[i].split(" ");
        }
        Arrays.sort(splitedInfo, (s1, s2) -> Integer.parseInt(s2[4]) - Integer.parseInt(s1[4]));
        
        for(int i = 0; i < info.length; i++){
            scorePutInMap(splitedInfo[i], 0);
        }
        
        HashMap<String, Integer[]> scoreArrayMap = new HashMap<>();
        for(String key : scoreMap.keySet()){
            scoreArrayMap.put(key, scoreMap.get(key).toArray(new Integer[scoreMap.get(key).size()]));
        }
                
        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++){
            String[] splitedQuery = query[i].split(" and | ");
            Integer[] list = scoreArrayMap.getOrDefault(new StringBuilder()
                                                            .append(splitedQuery[0])
                                                            .append(splitedQuery[1])
                                                            .append(splitedQuery[2])
                                                            .append(splitedQuery[3])
                                                            .toString(), new Integer[0]);
            int score = Integer.parseInt(splitedQuery[4]);
            int count = 0;
            int maxCount = list.length;
            while(count < maxCount && list[count] >= score){
                count++;
            }
            answer[i] = count;
        }
        
        return answer;
    }
    
    private void scorePutInMap(String[] splitedInfo, int dept) {
        if(dept == 4){
            String str = new StringBuilder()
                .append(splitedInfo[0])
                .append(splitedInfo[1])
                .append(splitedInfo[2])
                .append(splitedInfo[3])
                .toString();
            ArrayList<Integer> list = scoreMap.getOrDefault(str, new ArrayList<Integer>());
            list.add(Integer.parseInt(splitedInfo[4]));
            scoreMap.put(str, list);
        } else {
            scorePutInMap(splitedInfo, dept + 1);
            
            String[] newSplitedInfo = Arrays.copyOf(splitedInfo, 5);
            newSplitedInfo[dept] = "-";
            scorePutInMap(newSplitedInfo, dept + 1);
        }
    }
}