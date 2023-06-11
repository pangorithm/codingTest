class Solution {
    public String[] solution(String myString) {
        if(myString.startsWith("x")){
         myString = myString.replaceFirst("[x]+", "");
        }
        String[] ans = myString.replaceAll("[x]+", "x").split("x");
        boolean notFinished = true;
        while(notFinished){
            notFinished = false;
            for(int i = 0; i < ans.length - 1; i++){
                if((ans[i].length() > ans[i + 1].length()) && ans[i].startsWith(ans[i + 1])){
                    String temp = ans[i];
                    ans[i] = ans[i + 1];
                    ans[i + 1] = temp;
                    notFinished = true;  
                    continue;
                }
                int length = Math.min(ans[i].length(), ans[i + 1].length());
                for(int j = 0; j < length; j++){
                    if(ans[i].charAt(j) > ans[i + 1].charAt(j)){
                        String temp = ans[i];
                        ans[i] = ans[i + 1];
                        ans[i + 1] = temp;
                        notFinished = true;
                        break;
                    } else if(ans[i].charAt(j) < ans[i + 1].charAt(j)){
                        break;
                    } 
                }
            }
        }        
        return ans;
    }
}