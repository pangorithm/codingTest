import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        for(int count = 1; count < elements.length; count++){
            for(int start = 0; start < elements.length; start++){
                int sum = 0;
                for(int i = 0; i < count; i++){
                    sum += elements[(start + i) % elements.length];
                }
                set.add(sum);
            }
            int sum = 0;
            for(int num : elements){
                sum += num;
            }
            set.add(sum);
        }
        return set.size();
    }
}