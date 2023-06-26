import java.util.*;

public class Solution {
    public int solution(int n) {        
        int ans = 0;
        while(n > 0){
            if((n & 1) == 1){
                ans++;
                n = n >> 1;
            } else {
                n = n >> 1;
            }
        }
        
        return ans;
    }
}