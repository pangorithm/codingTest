import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int box = 1;
        while(true){
            if((i < order.length) && (box == order[i])){
                answer++;
                i++;
                box++;
            } else if((i < order.length) && (!stack.empty()) && (stack.peek() == order[i])){
                stack.pop();
                answer++;
                i++;
            } else if((i < order.length) && (box < order[i])){
                stack.push(box++);
            } else {
                break;
            }
        }
        return answer;
    }
}