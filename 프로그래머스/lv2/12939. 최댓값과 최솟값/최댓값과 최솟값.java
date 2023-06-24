import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] splited = s.split(" ");
        int[] arr = new int[splited.length];
        for(int i = 0; i < splited.length; i++){
            arr[i] = Integer.parseInt(splited[i]);
        }
        Arrays.sort(arr);
        return arr[0] + " " + arr[arr.length - 1];
    }
}