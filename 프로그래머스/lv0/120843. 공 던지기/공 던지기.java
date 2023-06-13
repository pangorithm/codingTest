class Solution {
    public int solution(int[] numbers, int k) {
        int x = 1;
        int i = 0;
        while(x != k){
            x++;
            i += 2;
        }
        return numbers[i % numbers.length];
    }
}