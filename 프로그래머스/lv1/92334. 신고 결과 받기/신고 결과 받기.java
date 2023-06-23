import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String> reportSet = new HashSet<>();
        for(String str : report){
            reportSet.add(str);
        }
        String[] report_list = new String[reportSet.size()];
        report_list = reportSet.toArray(report_list);
        
        HashMap<String, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            indexMap.put(id_list[i], i);
        }
        int[] reported = new int[id_list.length];
        int[] answer = new int[id_list.length];
        HashSet<String> blocked = new HashSet<>();
        
        for(String str : report_list){
            String[] rpt = str.split(" ");
            reported[indexMap.get(rpt[1])]++;
            if(reported[indexMap.get(rpt[1])] == k){
                blocked.add(rpt[1]);
            }
        }
        
        for(String str : report_list){
            String[] rpt = str.split(" ");
            if(blocked.contains(rpt[1])){
                answer[indexMap.get(rpt[0])]++;
            }
        }
        
        return answer;
    }
}