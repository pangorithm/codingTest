class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(isPrime(nums[i] + nums[j] + nums[k])){
                        // System.out.printf("%d : %b\n",nums[i] + nums[j] + nums[k],isPrime(nums[i] + nums[j] + nums[k]));
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    
    boolean isPrime(int n){
        if(n == 1){
            return false;
        }
        if(n == 2){
            return true;
        }
        if((n & 1) == 0){
            return false;
        }
        
        int i = 3;
        for(; i * i <= n; i += 2){
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }
}