class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = 0;
        int divisor = 0;
        for(int i = 1; i < n + 1; i++){
            count = 0;
            for(divisor = 1; divisor * divisor < i; divisor++){
                if(i % divisor == 0){
                    count++;
                }
            }
            if(divisor * divisor == i){
                count = (count << 1) + 1;
            }else{
                count = count << 1;
            }
            if(count > 2){
                answer++;
            }
        }
        return answer;
    }
}