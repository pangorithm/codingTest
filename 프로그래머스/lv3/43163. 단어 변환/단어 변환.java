import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        
        Queue<State> bfs = new ArrayDeque<>();
        bfs.offer(new State(begin, 1));
        while(bfs.size() > 0){
            State state = bfs.poll();
            char[] carr = state.str.toCharArray();
            loop : for(String word : words){
                int count = 0;
                char[] wordChar = word.toCharArray();
                for(int i = 0; i < carr.length; i++){
                    if(carr[i] != wordChar[i]){
                        count++;
                        if(count > 1){
                            continue loop;
                        }
                    }
                }
                if(count == 1){
                    if(word.equals(target)){
                        return state.step;
                    }
                    if(state.step < words.length){
                        bfs.offer(new State(word, state.step + 1));
                    }                    
                }
            }
        }
        
        return 0;
    }
    
    class State{
        String str;
        int step;
        
        State(String str, int step){
            this.str = str;
            this.step = step;
        }
    }
}