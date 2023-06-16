class Solution {
    public int[] solution(int l, int r) {
        int start = getstart(l);
        int end = getend(r);
        if(start > end){
            int[] answer = {-1};
            return answer;
        }
        int[] intarr = new int[end - start + 1];
        for(int i = 0; i < intarr.length; i++){
            intarr[i] = Integer.parseInt(Integer.toString((start + i), 2).replaceAll("1", "5"));
        }
        
        return intarr;
    }
    
    int getstart (int l) {
        int i = 0;
        while(Integer.parseInt(Integer.toString(i, 2).replaceAll("1", "5")) < l){
            i++;
        }
        return i;
    }
    
    int getend(int r) {
        int i = 0;
        while(Integer.parseInt(Integer.toString(i, 2).replaceAll("1", "5")) <= r){
            i++;
        }
        return --i;
    }
}