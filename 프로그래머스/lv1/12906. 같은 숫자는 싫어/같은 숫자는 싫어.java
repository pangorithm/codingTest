import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int prev = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != prev){
                list.add(arr[i]);
                prev = arr[i];
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}