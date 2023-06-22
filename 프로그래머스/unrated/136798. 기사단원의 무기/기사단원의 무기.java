class Solution {
    public int solution(int number, int limit, int power) {
        int[] dc = new int[number];
        int answer = 0;
        for(int i = 0; i < number; i++){
            dc[i] = getDivCount(i + 1, limit, power);
            // System.out.println(dc[i]);
            answer += dc[i];
        }
        return answer;
    }
    
    int getDivCount(int n, int limit, int power){
        int answer = 0;
        int i = 1;
        double  sqrt = Math.sqrt(n); 
        while(i < sqrt){
            if(n % i++ == 0){
                answer += 2;
            }
            if(answer > limit){
                return power;
            }
        }
        if(i == sqrt){
            answer++;
        }
        if(answer > limit){
            return power;
        }
        return answer;
    }
}