import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (v1, v2) -> v1[1].compareTo(v2[1]));
        String[] answer = new String[plans.length];
        int index = 0;
        
        for(int i = 0; i < plans.length; i++){
            String[] splited = plans[i][1].split(":");
            plans[i][1] = Integer.toString(Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]));
        }
        
        Stack<String[]> stack = new Stack<>();
        for(int i = 1; i < plans.length; i++){
            int elapsedTime = Integer.parseInt(plans[i][1]) - Integer.parseInt(plans[i - 1][1]);
            int needTime = Integer.parseInt(plans[i - 1][2]);
            
            if(elapsedTime < needTime){
                plans[i - 1][2] = Integer.toString(needTime - elapsedTime);
                stack.push(plans[i - 1]);
                
            } else {                
                answer[index++] = plans[i - 1][0];
                elapsedTime -= needTime;
                
                while(!stack.empty() && Integer.parseInt(stack.peek()[2]) <= elapsedTime){
                    String[] plan = stack.pop();
                    elapsedTime -= Integer.parseInt(plan[2]);
                    answer[index++] = plan[0];
                }
                if(!stack.empty()){
                    String[] plan = stack.pop();
                    plan[2] = Integer.toString(Integer.parseInt(plan[2]) - elapsedTime);
                    stack.push(plan);
                }
            }
        }
        answer[index++] = plans[plans.length - 1][0];
            
        while(!stack.empty()){
            String[] plan = stack.pop();
            answer[index++] = plan[0];
        }
        
        return answer;
    }
}