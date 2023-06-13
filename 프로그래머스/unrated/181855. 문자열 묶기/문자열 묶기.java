class Solution {
    public int solution(String[] strArr) {
        int[] sl = new int[strArr.length];
        for(int i = 0; i < sl.length; i++){
            sl[i] = strArr[i].length();
        }
        int max = 0;
        for(int i = 0; i < sl.length; i++){
            int count = 1;
            for(int j = i + 1; j < sl.length; j++){
                if(sl[i] == sl[j]){
                    count++;
                }
            }
            if(count > max){
                max = count;
            }
        }
        return max;
    }
}