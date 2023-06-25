import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[2];        
        set.add(words[0]);
        for(int i = 1; i < words.length; i++){
            if(set.contains(words[i]) || (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))){
                answer[1] = i / n + 1;
                answer[0] = i % n + 1;
                break;
            } else {
                set.add(words[i]);
            }
        }

        return answer;
    }
}