class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        long[] counts = new long[e + 1];
        int sqrt = (int) Math.sqrt(e);
        for(int i = 1; i <= sqrt; i++){
            counts[i * i]++;
        }
        for(int i = 1; i <= sqrt; i++){
            int num = i * i + i;
            while(num <= e){
                counts[num] += 2;
                num += i;
            }
        }
        
        int[] dp =  new int[e + 1];
        dp[e] = e;
        for(int i = e - 1; i > 0; i--){
            if(counts[dp[i + 1]] <= counts[i]){
                dp[i] = i;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = dp[starts[i]];
        }
        return answer;
    }
}