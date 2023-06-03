class Solution {
    public int solution(int[] numbers) {
        int max0 = 0;
        int max1 = 0;
        for(int num : numbers){
            if(num > max0){
                max1 = max0;
                max0 = num;
            }else if (num <= max0 && num > max1){
                max1 = num;
            }
        }
        int answer = max0 * max1;
        return answer;
    }
}