class Solution {
    public int[] solution(int n) {
        int count = 0;
        int i;
        for(i = 1; i * i < n; i++){
            if(n % i == 0){
                count++;
            }
        }
        if(i * i == n){
            count = (count << 1) + 1;
        } else {
            count = count << 1;
        }
        
        int[] answer = new int[count];
        int index = 0;
        for(i = 1; i * i < n; i++){
            if(n % i == 0){
                answer[index++] = i;
                answer[count - index] = n / i;
            }
        }
        if(i * i == n){
            answer[((count + 1) >> 1) - 1] = i;
        }
        return answer;
    }
}