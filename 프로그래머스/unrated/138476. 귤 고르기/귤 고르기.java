import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int size : tangerine){
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        Integer[] arr = map.keySet().toArray(new Integer[map.size()]);
        int[][] dic = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++){
            dic[i][0] = arr[i];
            dic[i][1] = map.get(arr[i]);
        }
        Arrays.sort(dic, (v1, v2) -> v2[1] - v1[1]);
        // for(int i = 0; i < dic.length; i++){         
        //     System.out.println(dic[i][0] + ":" + dic[i][1]);   
        // }
        
        int answer = 0;
        int sum = 0;
        int i = 0;
        
        while(sum < k){
            sum += dic[i++][1];
            answer++;
        }
        
        return answer;
    }
}