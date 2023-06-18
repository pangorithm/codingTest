import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public long solution(long n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(n > 0){
            list.add((int)(n % 10));
            n /= 10;
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder strbuilder = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            strbuilder.append(list.get(i));
        }
        return Long.parseLong(strbuilder.toString());
    }
}