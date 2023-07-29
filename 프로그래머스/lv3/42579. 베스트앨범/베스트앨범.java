import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, State> genresMap = new HashMap<>();
        for(int i = 0; i < plays.length; i++){
            State state = genresMap.getOrDefault(genres[i], new State());
            state.pq.add(new Info(i, plays[i]));
            state.playCount += plays[i];
            genresMap.put(genres[i], state);
        }
        
        String[] sortedGenres = genresMap.keySet().toArray(new String[genresMap.size()]);
        Arrays.sort(sortedGenres, (s1, s2) -> genresMap.get(s2).playCount - genresMap.get(s1).playCount);
        // System.out.println(Arrays.toString(sortedGenres));
        
        ArrayList<Integer> answerList = new ArrayList<>();
        for(String gen : sortedGenres){
            State state = genresMap.get(gen);
            answerList.add(state.pq.poll().pk);
            if(state.pq.size() > 0){
                answerList.add(state.pq.poll().pk);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    class State {
        PriorityQueue<Info> pq = new PriorityQueue<>((v1, v2) -> v2.play - v1.play);
        int playCount = 0;
    }
    
    class Info {
        int pk;
        int play;
        
        Info(int pk, int play){
            this.pk = pk;
            this.play = play;
        }
    }
}