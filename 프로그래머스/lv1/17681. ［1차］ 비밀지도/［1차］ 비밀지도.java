class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            arr1[i] = arr1[i] | arr2[i];
            char[] bstrch = Integer.toBinaryString(arr1[i]).toCharArray();
            char[] carr = new char[n];
            for(int j = 0; j < n - bstrch.length; j++){
                carr[j] = '0';
            }
            for(int j = 0; j < bstrch.length; j++){
                carr[n - bstrch.length + j] = bstrch[j];
            }
            answer[i] = String.valueOf(carr).replaceAll("1", "#").replaceAll("0", " ");
        }
        return answer;
    }
}