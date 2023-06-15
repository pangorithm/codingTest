class Solution {
    public int[] solution(int[] numlist, int n) {
        boolean nf = true;
        while(nf){
            nf = false;
            int temp = 0;
            for(int i = 1; i < numlist.length; i++){
                if(Math.abs(numlist[i - 1] - n) > Math.abs(numlist[i] - n)){
                    temp = numlist[i - 1];
                    numlist[i - 1] = numlist[i];
                    numlist[i] = temp;
                    nf = true;                                
                } else if(Math.abs(numlist[i - 1] - n) == Math.abs(numlist[i] - n)){
                    if(numlist[i - 1] < numlist[i]){
                        temp = numlist[i - 1];
                        numlist[i - 1] = numlist[i];
                        numlist[i] = temp;
                        nf = true;
                    }
                }
            }
        }
        return numlist;
    }
}