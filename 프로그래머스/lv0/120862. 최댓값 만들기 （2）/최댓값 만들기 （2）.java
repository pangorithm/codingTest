class Solution {
    public int solution(int[] numbers) {
        if(numbers.length == 2){
            return numbers[0] * numbers[1];
        }
        int max0 = 0;
        int max1 = 0;
        int umax0 = 0;
        int umax1 = 0;
        for(int num : numbers){
            if(num > 0){
                if(num >= max0){
                    max1 = max0;
                    max0 = num;
                } else if(num > max1){
                    max1 = num;
                }
            } else if (num < 0){
                if(num <= umax0){
                    umax1 = umax0;
                    umax0 = num;
                } else if(num < umax1){
                    umax1 = num;
                }
            }
        }
        return Math.max((max0 * max1) , (umax0 * umax1));
    }
}