class Solution {
    public String[] solution(String my_string) {
        int length = my_string.length();
        String[] answer = new String[length];
        for(int i = 0; i < length; i++){
            answer[i] = my_string.substring(length - i - 1, length);
        }
        
        boolean notFinish = true; 
        
        while(notFinish){
            notFinish = false;
            for(int i = 0; i < answer.length - 1; i++){
                int leng = Math.min(answer[i].length(), answer[i + 1].length());
                loop: for(int j = 0; j < leng;){
                    while(answer[i].charAt(j) == answer[i + 1].charAt(j)){
                        j++;
                        if(j == leng){
                            if(answer[i].length() > answer[i + 1].length()){
                                 String temp = answer[i];
                                 answer[i] = answer[i + 1];
                                 answer[i + 1] = temp;
                            }
                            break loop;
                        }
                    }
                    if(answer[i].charAt(j) > answer[i + 1].charAt(j)){
                        notFinish = true;
                        String temp = answer[i];
                        answer[i] = answer[i + 1];
                        answer[i + 1] = temp; 
                        break;
                    } else {
                        break;
                    }
                    
                }
            }
        }
        return answer;
    }
    
    
}