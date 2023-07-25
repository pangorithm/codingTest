class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++){
            int temp = 0;
            int min = Integer.MAX_VALUE;
            if(startX != balls[i][0]){
                temp = startX - balls[i][0];
                int x2 = temp * temp;
                temp = startY + balls[i][1];
                min = Math.min(temp * temp + x2, min);
                temp = (n - startY) + (n - balls[i][1]);
                min = Math.min(temp * temp + x2, min);
            } else {
                if(startY < balls[i][1]){
                    temp = startY + balls[i][1];
                    min = Math.min(temp * temp, min);
                } else {                    
                    temp = n - startY + n - balls[i][1];
                    min = Math.min(temp * temp, min);
                }                
            }
            if(startY != balls[i][1]){  
                temp = startY - balls[i][1];
                int y2 = temp * temp;
                temp = startX + balls[i][0];
                min = Math.min(temp * temp + y2, min);
                temp = (m - startX) + (m - balls[i][0]);
                min = Math.min(temp * temp + y2, min);
            } else {
                if(startX < balls[i][0]){
                    temp = startX + balls[i][0];
                    min = Math.min(temp * temp, min);
                } else {                    
                    temp = m - startX + m - balls[i][0];
                    min = Math.min(temp * temp, min);
                }
            }
            answer[i] = min;
        }
        
        return answer;
    }
}