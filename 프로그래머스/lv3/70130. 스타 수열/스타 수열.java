import java.util.*;

class Solution {
    public int solution(int[] a) {
        int[] arr = new int[a.length + 2];
        int[] check = new int[arr.length];
        
        arr[0] = a[0];
        arr[a.length + 1] = a[a.length - 1];
        for(int i = 0; i < a.length; i++){
            arr[i + 1] = a[i];
        }
        Arrays.fill(check, -1);
        
        HashMap<Integer, Integer> map = new HashMap<>(); // <숫자, 개수>
        for(int i = 1; i <= a.length; i++){
            if(arr[i - 1] != arr[i] && check[i - 1] != arr[i]){
                check[i - 1] = arr[i];
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            } else if(arr[i + 1] != arr[i] && check[i + 1] != arr[i]){
                check[i + 1] = arr[i];
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
        }
        // System.out.println(map);
        
        int answer = 0;
        for(Integer key : map.keySet().toArray(new Integer[0])){
            if(answer < map.get(key)){
                answer = map.get(key);
            }
        }
        
        return answer << 1;
    }
}