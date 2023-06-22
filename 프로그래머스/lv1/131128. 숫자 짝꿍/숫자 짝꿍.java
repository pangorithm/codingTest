class Solution {
    public String solution(String X, String Y) {
        char[] xch = X.toCharArray();
        char[] ych = Y.toCharArray();
               
        int[] xcount = new int[10];
        int[] ycount = new int[10];
        
        for(char ch : xch){
            xcount[ch - '0']++;
        }
        for(char ch : ych){
            ycount[ch - '0']++;
        }
        
        StringBuilder str = new StringBuilder();
        
        for(int i = 9; i > -1; i--){
            for(int j = 0; j < Math.min(xcount[i], ycount[i]); j++){
                str.append(i);
            }
        }
        
        String answer = str.toString();
        
        if(answer.length() == 0){
            return "-1";
        } 
        if(answer.startsWith("0")){
            return "0";
        }
        return str.toString();
    }
}