class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int aGCD = arrayA[0];
        int bGCD = arrayB[0];
        for(int i = 1; i < arrayA.length; i++){
            aGCD = getGCD(arrayA[i], aGCD);
            bGCD = getGCD(arrayB[i], bGCD);
        }
        
        for(int b : arrayB){
            if(b % aGCD == 0){
                aGCD = 0;
                break;
            }
        }
        
        for(int a : arrayA){
            if(a % bGCD == 0){
                bGCD = 0;
                break;
            }
        }
        
        return Math.max(aGCD, bGCD);
    }
    
    int getGCD (int a, int b) {
        int temp = a % b;
        if(temp == 0){
            return b;
        }
        return getGCD(b, temp);
    }
}