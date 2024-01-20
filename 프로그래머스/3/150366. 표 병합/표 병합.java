import java.util.*;

class Solution {
    int[] group = new int[2602];
    List<Integer>[] subgroupLists = new ArrayList[2602];
    String[] groupValues = new String[2602];
    Map<String, HashSet<Integer>> valueGroupSetMap = new HashMap<>();
    List<String> printList = new ArrayList<>();
    
    public String[] solution(String[] commands) {
        int r = 0;
        int c = 0;
        String value = "EMPTY";
        for(int i = 0; i < 2602; i++){
            group[i] = i;
            subgroupLists[i] = new ArrayList<>();
        }
        
        
        for(String cmdStr : commands){
            StringTokenizer st = new StringTokenizer(cmdStr);
            switch (st.nextToken()){
                case "UPDATE" :
                    if(st.countTokens() > 2){
                        r = Integer.parseInt(st.nextToken());
                        c = Integer.parseInt(st.nextToken());
                        value = st.nextToken();
                        int group = find(getGroupByRC(r, c));
                        
                        if(groupValues[group] != null){
                            valueGroupSetMap.get(groupValues[group]).remove(group);
                        }
                        groupValues[group] = value;
                        if(!valueGroupSetMap.containsKey(value)){
                            valueGroupSetMap.put(value, new HashSet<>());
                        }
                        valueGroupSetMap.get(value).add(group);
                        
                    } else {
                        String value1 = st.nextToken();
                        String value2 = st.nextToken();
                        
                        HashSet<Integer> set1 = valueGroupSetMap.getOrDefault(value1, new HashSet<>());
                        for(int g : set1){
                            groupValues[g] = value2;
                        }                        
                        valueGroupSetMap.remove(value1);
                        
                        HashSet<Integer> set2 = valueGroupSetMap.getOrDefault(value2, new HashSet<>());
                        set2.addAll(set1);
                        valueGroupSetMap.put(value2, set2);
                    }
                    break;
                    
                case "MERGE" :
                    int r1 = Integer.parseInt(st.nextToken());
                    int c1 = Integer.parseInt(st.nextToken());
                    int r2 = Integer.parseInt(st.nextToken());
                    int c2 = Integer.parseInt(st.nextToken());
                    int group1 = find(getGroupByRC(r1, c1));
                    int group2 = find(getGroupByRC(r2, c2));
                    if(group1 == group2){
                        continue;
                    }
                    
                    if(groupValues[group1] == null && groupValues[group2] != null){
                        union(group2, group1);
                    } else {
                        if(groupValues[group2] != null){
                            valueGroupSetMap.get(groupValues[group2]).remove(group2);
                        }
                        union(group1, group2);
                    }
                    
                    break;
                    
                case "UNMERGE" :
                    r = Integer.parseInt(st.nextToken());
                    c = Integer.parseInt(st.nextToken());
                    int rc = getGroupByRC(r, c);
                    int group = find(rc);
                    value = groupValues[group];
                    if(value != null){
                        valueGroupSetMap.get(value).remove(group);
                        valueGroupSetMap.get(value).add(rc);
                    }
                    division(group);
                    groupValues[rc] = value;
                    break;
                    
                case "PRINT" :
                    r = Integer.parseInt(st.nextToken());
                    c = Integer.parseInt(st.nextToken());
                    value = groupValues[find(getGroupByRC(r, c))];
                    printList.add(value == null ? "EMPTY" : value);
                    break;
            }
        }
        
        
        String[] answer = printList.toArray(new String[printList.size()]);
        return answer;
    }
    
    int find(int index){
        if(group[index] == index){
            return index;
        } else {
            return group[index] = find(group[index]);
        }
    }
    
    void union(int a, int b){
        subgroupLists[a].add(b);
        group[b] = a;
    }
    
    void division(int pNode){
        groupValues[pNode] = null;
        for(int sbg : subgroupLists[pNode]){
            group[sbg] = sbg;
            division(sbg);
        }
        subgroupLists[pNode] = new ArrayList<>();
    }
    
    int getGroupByRC(int r, int c){
        return r * 51 + c;
    }
}