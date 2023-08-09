class Solution {
    public int solution(int[] a) {
        int min = Integer.MAX_VALUE;
        for(int n : a){
            if(min > n){
                min = n;
            }
        }
        
        int answer = 1;
        int temp = Integer.MAX_VALUE;
        for(int i = 0; a[i] > min; i++){
            if(temp > a[i]){
                temp = a[i];
                answer++;
            }
        } 
        temp = Integer.MAX_VALUE;
        for(int i = a.length - 1; a[i] > min; i--){
            if(temp > a[i]){
                temp = a[i];
                answer++;
            }
        }
        
        return answer;
    }
}