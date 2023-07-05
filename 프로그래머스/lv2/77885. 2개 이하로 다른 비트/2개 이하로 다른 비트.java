class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < answer.length; i++){
            Long or = numbers[i] | (numbers[i] + 1);
            Long xor = numbers[i] ^ or;
            answer[i] = or - (xor >> 1);
        }
        return answer;
    }
}