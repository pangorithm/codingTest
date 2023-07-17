import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] mineralFatigueSum = new int[picks[0] + picks[1] + picks[2]][2];
        for(int i = 0; i < mineralFatigueSum.length; i++){
            mineralFatigueSum[i][1] = i;
            for(int j = 0; j < 5 && i * 5 + j < minerals.length; j++){
                switch (minerals[i * 5 + j]){
                    case "diamond" : mineralFatigueSum[i][0] += 25; break;
                    case "iron" : mineralFatigueSum[i][0] += 5; break;
                    case "stone" : mineralFatigueSum[i][0] += 1; break;
                }
            }            
        }
        // for(int[] f : mineralFatigues){
        //     System.out.println(f[0]);            
        // }        
        Arrays.sort(mineralFatigueSum, (v1, v2) -> v2[0] - v1[0]);
        // for(int[] f : mineralFatigueSum){
        //     System.out.println(Arrays.toString(f));            
        // }
        
        String[] pickUse = new String[mineralFatigueSum.length];
        for(int[] f: mineralFatigueSum){
            if(picks[0] > 0){
                pickUse[f[1]] = "dia";
                picks[0]--;
            } else if (picks[1] > 0){
                pickUse[f[1]] = "iron";
                picks[1]--;
            }  else if (picks[2] > 0){
                pickUse[f[1]] = "stone";
                picks[2]--;
            }
        }
        // System.out.println(Arrays.toString(pickUse)); 
        
        int answer = 0;
        for(int i = 0; i < pickUse.length; i++){
            for(int j = 0; j < 5 && i * 5 + j < minerals.length; j++){
                switch (pickUse[i]){
                    case "dia" : 
                        switch (minerals[i * 5 + j]){
                            case "diamond" : answer++; break;
                            case "iron" : answer++; break;
                            case "stone" : answer++; break;
                        }
                        break;
                    case "iron" : 
                        switch (minerals[i * 5 + j]){
                            case "diamond" : answer += 5; break;
                            case "iron" : answer += 1; break;
                            case "stone" : answer += 1; break;
                        }
                        break;
                    case "stone" : 
                        switch (minerals[i * 5 + j]){
                            case "diamond" : answer += 25; break;
                            case "iron" : answer += 5; break;
                            case "stone" : answer += 1; break;
                        }
                        break;
                }
            } 
        }
        
        return answer;
    }
}