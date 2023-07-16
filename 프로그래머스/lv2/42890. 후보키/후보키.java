import java.util.*;

class Solution {    
    public int solution(String[][] relation) {
        HashSet<HashSet> keySet = new HashSet<>();
        Queue<HashSet> bfs = new ArrayDeque<>();
        for(int i = 0; i < relation[0].length; i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            bfs.add(set);
        }
        
        while(bfs.size() > 0){
            HashSet<Integer> colSet = bfs.poll();
            Integer[] cols = colSet.toArray(new Integer[0]);
            String[] tuples = new String[relation.length];
            for(int i = 0; i < tuples.length; i++){
                StringBuilder str = new StringBuilder();
                for(Integer col : cols){
                    str.append(relation[i][col]);
                    str.append(",");
                }
                tuples[i] = str.toString();
            }
            Arrays.sort(tuples);
            boolean check = true;
            for(int i = 1; i < tuples.length; i++){
                if(tuples[i].equals(tuples[i - 1])){
                    check = false;
                    break;
                }
            }
            if(check){ // 유일성을 만족할 경우
                keySet.add(colSet);
            } else { // 유일성을 만족하지 않을 경우 속성을 추가 
                for(int i = 0; i < relation[0].length; i++){
                    if(!colSet.contains(i)){                      
                        HashSet<Integer> nextSet = new HashSet<>(colSet);
                        nextSet.add(i); 
                        HashSet[] keySets = keySet.toArray(new HashSet[0]);
                        check = true;
                        for(HashSet set : keySets){  // 속성을 추가한 경우가 최소성을 만족하지 않을 경우                     
                            if(nextSet.containsAll(set)){   
                                check = false;
                                break;
                            }
                        }
                        if(check){
                            bfs.offer(nextSet);
                        }
                    }
                }
            }
        }
        
        // 최소성 재확인
        HashSet[] keySets = keySet.toArray(new HashSet[0]);
        for(HashSet set1 : keySets){ 
            keySets = keySet.toArray(new HashSet[0]);
            for(HashSet set2 : keySets){                   
                if(set1.containsAll(set2)){
                    if(set1.size() > set2.size()){
                        keySet.remove(set1);
                    }
                }
            }
        }
        
        // System.out.println(keySet);
        return keySet.size();
    }    
}