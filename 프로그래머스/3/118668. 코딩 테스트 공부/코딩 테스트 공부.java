import java.util.*;

class Solution {
    int[][] problemArr;
    int maxAlpReq = 0;
    int maxCopReq = 0;
    int[][] dp;
    int minCost = Integer.MAX_VALUE;
    
    public int solution(int alp, int cop, int[][] problems) {
        problemArr = problems;
        
        for(int[] p : problems){
            if(maxAlpReq < p[0]){
                maxAlpReq = p[0];
            }
            if(maxCopReq < p[1]){
                maxCopReq = p[1];
            }          
        }
        if(alp > maxAlpReq){
            alp = maxAlpReq;
        }
        if(cop > maxCopReq){
            cop = maxCopReq;
        }
        
        dp = new int[maxAlpReq + 1][maxCopReq + 1];
        for(int i = alp; i <= maxAlpReq; i++){
            for(int j = cop; j <= maxCopReq; j++){
                dp[i][j] = 300;
            }
        }
        dp[alp][cop] = 0;
        
        search(alp, cop, 0);
        
        return dp[maxAlpReq][maxCopReq];
    }
    
    void search(int alp, int cop, int cost){
        
        for(int[] p : problemArr){
            if(alp >= p[0] && cop >= p[1]){
                int nAlp = Math.min(alp + p[2], maxAlpReq);
                int nCop = Math.min(cop + p[3], maxCopReq);
                int nCost = cost + p[4];
                if(checkCost(nAlp, nCop, nCost)){
                    search(nAlp, nCop, nCost);
                }
            }
        }
        int nAlp = Math.min(alp + 1, maxAlpReq);
        int nCop = Math.min(cop + 1, maxCopReq);
        cost++;
        if(checkCost(nAlp, cop, cost)){
            search(nAlp, cop, cost);
        }
        if(checkCost(alp, nCop, cost)){
            search(alp, nCop, cost);
        }
    }
    
    boolean checkCost(int alp, int cop, int cost){
        
        if(dp[alp][cop] > cost){
            dp[alp][cop] = cost;
            return true;
        } else {
            return false;
        }
    }
}