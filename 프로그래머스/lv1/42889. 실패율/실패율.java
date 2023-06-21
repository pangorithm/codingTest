import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[] solution(int N, int[] stages) {
        // n-1 레벨을 클리어 == n레벨 도전중
        int[] clearCount = new int[N + 1];
        for(int onStage : stages){
            for(int i = 0; i < onStage; i++){
                clearCount[i]++; // 클리어한 스테이지의 카운트 증가
            }
        }
        float[] failRate = new float[N + 1];
        for(int i = 1; i < N + 1; i++){
            if(clearCount[i - 1] < clearCount[i]){
                failRate[i] = 1;
            }else{
                failRate[i] = (float) (clearCount[i - 1] - clearCount[i]) / (float) clearCount[i];
            }
        }
        
        LinkedList<Integer> list = new LinkedList<>();
        
        loop : for(int i = 1; i < N + 1; i++){
            for(int j = 0; j < list.size(); j++){
                if(failRate[list.get(j)] < failRate[i]){
                    list.add(j, i);
                    continue loop;
                }
            }
            list.add(i);
        }

        
        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            // System.out.printf("%d %f\n", list.getFirst(), failRate[list.getFirst()]);
            answer[i] = list.poll();
        }

        return answer;
    }
}