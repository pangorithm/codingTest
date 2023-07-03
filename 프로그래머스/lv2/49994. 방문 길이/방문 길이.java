class Solution {
    public int solution(String dirs) {
        char[] moves = dirs.toCharArray();
        boolean[][][] dp = new boolean[11][11][4]; // {y + 5, x + 5, {U, D, R, L}}
        int[] loc = {5, 5}; // {y, x}
        int answer = 0;
        
        for(char move : moves){
            switch (move) {
                case 'U':
                    if(loc[0] != 10){
                        if(dp[loc[0]][loc[1]][0] == false){
                            answer++;
                            dp[loc[0]][loc[1]][0] = true;
                            loc[0]++;
                            dp[loc[0]][loc[1]][1] = true;
                        } else {                            
                            loc[0]++;
                        }
                    }
                    break;
                case 'D':
                    if(loc[0] != 0){
                        if(dp[loc[0]][loc[1]][1] == false){
                            answer++;
                            dp[loc[0]][loc[1]][1] = true;
                            loc[0]--;
                            dp[loc[0]][loc[1]][0] = true;
                        } else {                            
                            loc[0]--;
                        }
                    }
                    break;
                case 'R':
                    if(loc[1] != 10){
                        if(dp[loc[0]][loc[1]][2] == false){
                            answer++;
                            dp[loc[0]][loc[1]][2] = true;
                            loc[1]++;
                            dp[loc[0]][loc[1]][3] = true;
                        } else {                            
                            loc[1]++;
                        }
                    }
                    break;
                case 'L':
                    if(loc[1] != 0){
                        if(dp[loc[0]][loc[1]][3] == false){
                            answer++;
                            dp[loc[0]][loc[1]][3] = true;
                            loc[1]--;
                            dp[loc[0]][loc[1]][2] = true;
                        } else {                            
                            loc[1]--;
                        }
                    }
                    break;
            }
        }
        
        return answer;
    }
}