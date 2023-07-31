import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int gemsSetSize = new HashSet<>(Arrays.asList(gems)).size();

        int[] answer = new int[2];
        int answerLength = gems.length, minIndex = 0;
        Map<String, Integer> gemsMap = new HashMap<>(); // <gem, count>
        for (int maxIndex = 0; maxIndex < gems.length; maxIndex++) {
            gemsMap.put(gems[maxIndex], gemsMap.getOrDefault(gems[maxIndex], 0) + 1);

            while (gemsMap.get(gems[minIndex]) > 1) {
                gemsMap.put(gems[minIndex], gemsMap.get(gems[minIndex]) - 1);
                minIndex++;
            }

            int length = maxIndex - minIndex;
            if (gemsMap.size() == gemsSetSize && answerLength > length) {
                answerLength = length;
                answer[0] = minIndex;
                answer[1] = maxIndex;
            }
        }

        answer[0]++;
        answer[1]++;
        return answer;
    }
}