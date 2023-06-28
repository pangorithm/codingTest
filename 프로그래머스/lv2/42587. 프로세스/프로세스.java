import java.util.Arrays;

class Solution {
    public int solution(int[] priorities, int location) {
        Integer[] sorted = new Integer[priorities.length];
        for(int i = 0; i < priorities.length; i++){
            sorted[i] = i;
        }
        
        Arrays.sort(sorted, (v1, v2) -> priorities[v2] - priorities[v1]);
        int sortedIndex = 0;
        for(int queIndex = 0; sortedIndex < priorities.length; queIndex++){
            int qIndex = queIndex % priorities.length;
            if(priorities[qIndex] == priorities[sorted[sortedIndex]]){
                // System.out.println(sortedIndex + ":" + qIndex);
                if(location == qIndex){ 
                    return sortedIndex + 1;
                }
                sortedIndex++;
                
            }            
        }
        return priorities.length - 1;
    }
}