class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        String str = "";
        for(int i = 0; i < flag.length; i++){
            if(flag[i]){
                str += Integer.toString(arr[i]).repeat(arr[i] * 2);
            } else {
                str = str.substring(0, str.length() - arr[i]);
            }
        }
        char[] ca = str.toCharArray();
        int[] answer = new int[ca.length];
        for(int i = 0; i < ca.length; i++){
            answer[i] = ca[i] - '0';
        }
        return answer;
    }
}