import java.util.*;

class Solution {
    public int solution(String s) {        
        char[] chs = s.toCharArray();        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < chs.length; i++){            
            int left = i;
            int startRight = chs.length - 1;
            int right = startRight;
            int count = 0;
            
            while(left < right){
                if(chs[left] == chs[right]){
                    left++;
                    right--;
                    count += 2;
                    
                } else {
                    left = i;
                    startRight--;
                    right = startRight;
                    count = 0;
                }
            }
            if(left == right){
                count++;
            }
            
            list.add(count);
            // System.out.println(i+" "+count);
        }
        
        int answer = 1;
        for(int i = 0; i < list.size(); i++){
            if(answer < list.get(i)){
                answer = list.get(i);
            }
        }
        
        return answer;
    }
}