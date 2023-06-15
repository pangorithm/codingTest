class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int max3 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;
        int max1 = Integer.MAX_VALUE;
        for(int i = 0; i < rank.length; i++){
            if(attendance[i] && rank[i] < max1){
                max3 = max2;
                max2 = max1;
                max1 = rank[i];
            } else if(attendance[i] && rank[i] < max2){
                max3 = max2;
                max2 = rank[i];
            } else if(attendance[i] && rank[i] < max3){
                max3 = rank[i];
            } 
        }
        int a = -1;
        int b = -1;
        int c = -1;
        for(int i = 0; i < rank.length; i++){
            if(rank[i] == max1){
                a = i;
            } else if(rank[i] == max2){
                b = i;
            } else if(rank[i] == max3){
                c = i;
            }
        }
        return 10000 * a + 100 * b + c;
    }
}