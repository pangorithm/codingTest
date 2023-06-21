class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2; i <= n; i++){
            if(isPrime(i)){
                answer++;
                // System.out.printf("%d : %b\n", i, isPrime(i));
            }
        }
        return answer;
    }
    
    boolean isPrime(int x){
        if(x == 1){
            return false;
        } else if(x == 2){
            return true;
        } else if((x & 1) == 0){
            return false;
        }
        for(int i = 3; i <= Math.sqrt(x); i += 2){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
}