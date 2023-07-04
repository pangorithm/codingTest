import java.util.TreeMap;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        TreeMap<Integer, HashSet> tree = new TreeMap<>(); // <value, index>
        int[] answer = new int[numbers.length];
        for(int i = 0; i < answer.length; i++){
            HashSet<Integer> set = tree.getOrDefault(numbers[i], new HashSet<>());
            set.add(i);
            tree.put(numbers[i], set);
            answer[i] = -1;
            for(int firstKey = tree.firstKey(); firstKey < numbers[i]; firstKey = tree.firstKey()){
                HashSet temp = tree.get(firstKey);
                Integer[] indexs = new Integer[temp.size()];
                temp.toArray(indexs);
                for(Integer index : indexs){
                    answer[index] = numbers[i];                    
                }
                tree.remove(firstKey);
            }            
        }        
        return answer;
    }
}