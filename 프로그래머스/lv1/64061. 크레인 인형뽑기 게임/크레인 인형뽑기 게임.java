import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for(int move : moves){
            for(int i = 0; i < board.length; i++){
                if(board[i][move - 1] > 0){
                    // System.out.println(board[i][move - 1]);   
                    if(!stack.empty() && stack.peek() == board[i][move - 1]){
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(board[i][move - 1]);
                    } 
                    // System.out.println(stack.peek());     
                    board[i][move - 1] = 0;              
                    break;
                }
            }
        }
        return answer;
    }
}