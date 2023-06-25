import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        char[] carr = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for(char ch : carr){
            if (stack.size() == 0){
                stack.push(ch);
            } else if(stack.peek() == ch){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}