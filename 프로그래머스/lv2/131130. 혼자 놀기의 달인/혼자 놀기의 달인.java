import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        for(int i = 0; i < cards.length; i++){
            HashSet<Integer> set1 = new HashSet<>();
            int boxNo = i;
            while(!set1.contains(boxNo)){
                set1.add(boxNo);
                boxNo = cards[boxNo] - 1;
            }
            if(set1.size() == cards.length){
                continue;
            }
            for(int j = 0; j < cards.length; j++){
                HashSet<Integer> set2 = new HashSet<>();
                boxNo = j;
                while(!set1.contains(boxNo) && !set2.contains(boxNo)){
                set2.add(boxNo);
                boxNo = cards[boxNo] - 1;
                }
                
                int temp = set1.size() * set2.size();
                if(temp > answer){
                    answer = temp;
                // System.out.println(set1);
                // System.out.println(set2);
                }
            }
        }
        return answer;
    }
}