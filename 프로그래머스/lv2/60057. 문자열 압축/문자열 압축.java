import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        if(answer < 4){
            return answer;
        }
        int length = answer;
        int maxSubSize = length >> 1;
        for(int subSize = 1; subSize <= maxSubSize; subSize++){
            ArrayDeque<String> substring = new ArrayDeque<>();
            ArrayDeque<Integer> count = new ArrayDeque<>();
            substring.add(s.substring(0, subSize));
            count.add(1);
            
            int maxI = length / subSize;
            int i = 1;
            while(i < maxI){
                String temp = s.substring(subSize * i, subSize * (i + 1));
                if(substring.getLast().equals(temp)){
                    count.addLast(count.removeLast() + 1);
                } else {
                    substring.addLast(temp);
                    count.addLast(1);
                }
                i++;
            }
            StringBuilder str = new StringBuilder();
            while(substring.size() > 0){
                int n = count.pollFirst();
                if(n > 1){
                    str.append(n);
                }
                str.append(substring.pollFirst());
            }
            
            str.append(s.substring(i * subSize));
            if(str.length() < answer){
                answer = str.length();
                // System.out.println(str.toString());
            }
        }
        return answer;
    }
}