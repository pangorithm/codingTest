class Solution {
    public int[] solution(int n, long left, long right) {
        int li = (int)(left / n);
        int lj = (int)(left % n);
        int ri = (int)(right / n);
        int rj = (int)(right % n);
        
        // int arr[] = new int[n * n];
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         arr[i * n + j] = Math.max(i, j) + 1;
        //     }
        // }
            
        int[] answer = new int[((int)(right - left)) + 1];
        int index = 0;
        if(li < ri){
            for(int j = lj; j < n; j++){
                answer[index] = Math.max(li, j) + 1;
                index++;
            }        
            for(int i = li + 1; i < ri; i++){
                for(int j = 0; j < n; j++){
                    answer[index] = Math.max(i, j) + 1;
                    index++;
                }
            }
            for(int j = 0; j <= rj; j++){
                answer[index] = Math.max(ri, j) + 1;
                index++;
            }
        } else if(li == ri){
            for(int j = lj; j <= rj; j++){
                answer[index] = Math.max(li, j) + 1;
                index++;
            }
        }
        return answer;
    }
}