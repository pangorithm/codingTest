import java.util.Stack;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int[] sign = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            sign[i] = 1;
        }
        
        int dept = 0;
        Stack<State> stack = new Stack<>();
        stack.add(new State(sign, dept));
        
        while(!stack.empty()){
            State state = stack.pop();
            if(state.dept != numbers.length){
                for(State next : getNextStates(state)){
                    stack.push(next);
                }
            } else {
                int sum = 0;
                for(int i = 0; i < numbers.length; i++){
                    sum += state.sign[i] * numbers[i];
                }
                if(sum == target){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    static class State {
        int[] sign;
        int dept;
        
        public State(int[] sign, int dept) {
            this.sign = sign;
            this.dept = dept;
        }
    }
    
    State[] getNextStates(State state){
        State[] nextStates = new State[2];
        nextStates[0] = new State(state.sign, state.dept + 1);
        int[] newSign = new int[state.sign.length];
        for(int i = 0; i < newSign.length; i++){
            newSign[i] = state.sign[i];
        }
        newSign[state.dept] = -1;
        nextStates[1] = new State(newSign, state.dept + 1);
        return nextStates;
    }
}