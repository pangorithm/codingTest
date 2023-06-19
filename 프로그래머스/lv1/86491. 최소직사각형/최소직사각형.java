class Solution {
    public int solution(int[][] sizes) {
        for(int i = 0; i < sizes.length; i++){
            int max = sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1];
            int min = sizes[i][0] < sizes[i][1] ? sizes[i][0] : sizes[i][1];
            sizes[i][0] = min;
            sizes[i][1] = max;
        }
        int[] wallet = new int[2];
        for(int[] e : sizes){
            if(e[0] > wallet[0]){
                wallet[0] = e[0];
            }
            if(e[1] > wallet[1]){
                wallet[1] = e[1];
            }
        }
        return wallet[0] * wallet[1];
    }
}