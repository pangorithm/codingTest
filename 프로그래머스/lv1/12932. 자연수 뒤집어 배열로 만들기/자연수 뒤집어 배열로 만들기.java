import java.util.ArrayList;
class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(n > 0){
            list.add((int)(n % 10));
            n /= 10;
        }
        int length = list.size();
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}