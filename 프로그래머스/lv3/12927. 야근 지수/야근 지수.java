class Solution {
    public long solution(int n, int[] works) {
        int[] copyWorks = new int[works.length];
        int sum = 0;
        for(int i = 0; i < works.length; i++){
            sum += works[i];
            copyWorks[i] =  works[i];
        }
        
        if(sum <= n){
            return 0;
        }
        sum -= n;
        
        int avg = sum / works.length;
        for(int i = 0; i < works.length; i++){
            if(works[i] > avg){
                n -= works[i] - avg;
                works[i] = avg;
            }
        }

        while(n < 0){
            for(int i = 0; i < works.length; i++){
                if(n == 0){
                    break;
                } else if(works[i] < copyWorks[i]){
                    works[i]++;
                    n++;
                }
            }
            avg++;
        }
        
        long answer = 0;
        for(int w : works){
            answer += (long) w * (long) w;
        }
        
        return answer;
    }
}