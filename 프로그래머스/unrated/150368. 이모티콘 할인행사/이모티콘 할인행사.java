import java.util.*;

class Solution {
    static int[] answer = new int[2];
    static HashMap<Integer, Integer>[] emoticonsMap;
        
    public int[] solution(int[][] users, int[] emoticons) {
        emoticonsMap = new HashMap[emoticons.length];
        for(int i = 0; i < emoticons.length; i++){
            emoticonsMap[i] = new HashMap<Integer, Integer>();
            for(int dc = 10; dc < 50; dc += 10){
                emoticonsMap[i].put(dc , emoticons[i] / 100 * (100 - dc));
            }
            // System.out.println(emoticonsMap[i]);
        }
        int[] init = new int[emoticons.length];
        calculate(0, init, users);
        
        return answer;
    }
    
    void calculate(int userCount, int[] state, int[][] users){
        if(userCount < emoticonsMap.length){
            for(int dc = 10; dc < 50; dc += 10){
                int[] next = Arrays.copyOf(state, state.length);
                next[userCount] = dc;
                calculate(userCount + 1, next, users);
            }
        } else {
            int count = 0;
            int usersSum = 0;
            for(int[] user : users){
                int userSum = 0;
                for(int i = 0; i < state.length; i++){
                    if(user[0] <= state[i]){
                        userSum += emoticonsMap[i].get(state[i]);
                    }
                }
                if(userSum >= user[1]){
                    count++;
                } else {
                    usersSum += userSum;
                }
            }
            if(count > answer[0]){
                // System.out.println(Arrays.toString(state));
                answer[0] = count;
                answer[1] = usersSum;
            } else if(count == answer[0]){
                answer[1] = Math.max(answer[1], usersSum);
            }
        }
    }
}