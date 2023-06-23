import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < ingredient.length; i++){
            if(ingredient[i] != 1){
                stack.push(ingredient[i]);
            } else if(stack.size() > 2){
                if(stack.peek() == 3){
                    int temp1 = stack.pop();
                    if(stack.peek() == 2){
                        int temp2 = stack.pop();
                        if(stack.peek() == 1){
                            stack.pop();
                            answer++;
                        } else {
                            stack.push(temp2);
                            stack.push(temp1);
                            stack.push(ingredient[i]);
                        }
                    } else {
                        stack.push(temp1);
                        stack.push(ingredient[i]);
                    }
                } else {
                    stack.push(ingredient[i]);                    
                }
            } else {
                stack.push(ingredient[i]);                
            }
        }
        return answer;
    }
}