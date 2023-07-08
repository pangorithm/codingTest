class Solution {
    public String solution(int n) {
        char[] arr = Integer.toString(n, 3).toCharArray();
        for(int i = arr.length - 1; i > 0; i--){
            if(arr[i] < '1'){
                arr[i - 1] -= 1;
                arr[i] += 3;
            }
        }
        return String.valueOf(arr).replaceAll("3", "4").replaceFirst("0", "");
    }
}