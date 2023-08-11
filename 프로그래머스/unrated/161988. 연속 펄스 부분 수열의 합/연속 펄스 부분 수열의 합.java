// import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long[] pps = new long[sequence.length]; // 1, -1, 1, ...
        long[] mps = new long[sequence.length]; // -1, 1, -1, ...
            
        pps[0] = sequence[0];
        mps[0] = - sequence[0];
        for(int i = 1; i < sequence.length; i++){
            if((i & 1) == 0){
                pps[i] = pps[i - 1] + sequence[i];
                mps[i] = mps[i - 1] - sequence[i];
            } else {
                pps[i] = pps[i - 1] - sequence[i];
                mps[i] = mps[i - 1] + sequence[i];                
            }
        }
        // System.out.println(Arrays.toString(pps));
        // System.out.println(Arrays.toString(mps));

        int ppsMaxIndex = 0;
        long ppsMax = Long.MIN_VALUE;
        
        int mpsMaxIndex = 0;
        long mpsMax = Long.MIN_VALUE;
        
        for(int i = 0; i < sequence.length; i++){
            if(ppsMax < pps[i]){
                ppsMax = pps[i];
                ppsMaxIndex = i;
            }
            if(mpsMax < mps[i]){
                mpsMax = mps[i];
                mpsMaxIndex = i;
            }
        }
        
        int ppsMinIndex = 0;
        long ppsMin = Long.MAX_VALUE;
        for(int i = 0; i < ppsMaxIndex; i++){
            if(ppsMin > pps[i]){
                ppsMin = pps[i];
                ppsMinIndex = i;
            }
        }
        
        int mpsMinIndex = 0;
        long mpsMin = Long.MAX_VALUE;
        for(int i = 0; i < mpsMaxIndex; i++){
            if(mpsMin > mps[i]){
                mpsMin = mps[i];
                mpsMinIndex = i;
            }
        }
        
        long ppsResult = ppsMax - Math.min(0, ppsMin);
        long mpsResult = mpsMax - Math.min(0, mpsMin);
        
        return Math.max(ppsResult, mpsResult);
    }
}