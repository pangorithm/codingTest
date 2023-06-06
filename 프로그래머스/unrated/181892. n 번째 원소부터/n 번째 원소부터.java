class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = slice(num_list, n);
        return answer;
    }
    
    int[] slice(int[] list, int n){
        int[] result = new int[list.length - n + 1];
        for(int i = 0; i + n - 1 < list.length; i++){
            result[i] = list[n - 1 + i];
        }
        return result;
    }
}