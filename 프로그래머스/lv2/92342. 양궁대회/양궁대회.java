import java.util.*;

class Solution {
    static int arrowCount;
    static int[] apeach;
    static int maxScoreDif = 0;
    static int[] answer = new int[11];
    
    public int[] solution(int n, int[] info) {
        arrowCount = n;
        apeach = info;
        
        getScore(0, answer, 0);
        
        if(maxScoreDif == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        return answer;
    }
    
    void getScore(int rionSum, int[] rion, int dept){
        if(rionSum == arrowCount){
            int rionScore = 0;
            int apeachScore = 0;
            for(int i = 0; i < 11; i++){
                if(rion[i] > apeach[i]){
                    rionScore += 10 - i;
                } else if(apeach[i] > 0){
                    apeachScore += 10 - i;
                }
            }
            
            int scoreDif = rionScore - apeachScore;
            // System.out.println(Arrays.toString(rion)+rionScore+" "+apeachScore);
            if(scoreDif > 0){
                if(scoreDif > maxScoreDif){
                    maxScoreDif = scoreDif;
                    answer = rion;
                } else if(scoreDif == maxScoreDif){
                    for(int i = 10; i >= 0; i--){
                        if(rion[i] > answer[i]){
                            answer = rion;
                            break;
                        } else if(rion[i] < answer[i]){
                            break;
                        }
                        
                    }
                }
            }
        } else {
            if(dept < 10){
                getScore(rionSum, rion, dept + 1);
                
                int[] newRion = Arrays.copyOf(rion, 11);
                newRion[dept] = apeach[dept] + 1;
                getScore(rionSum + newRion[dept], newRion, dept + 1);
            } else if(arrowCount > rionSum){
                int[] newRion = Arrays.copyOf(rion, 11);
                newRion[dept] = arrowCount - rionSum;
                getScore(rionSum + newRion[dept], newRion, dept + 1);
            }
        }
    }
}