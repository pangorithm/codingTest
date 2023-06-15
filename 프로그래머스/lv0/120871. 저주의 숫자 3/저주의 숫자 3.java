class Solution {
    public int solution(int n) {
        int answer = n + count3(n);
        int temp = n;
        while(answer - temp > 0){
            int add = count3(answer) - count3(temp);
            temp = answer;
            answer += add;
        }
        return answer;
    }
    boolean is3(int n){
        int sum = 0;
        while(n > 0){
        int x = n % 10;
            if(x == 3){
                return true;
            }
            sum += x;
            n /= 10;
        }
        return (sum % 3) == 0 ? true : false;
    }
    
    int count3(int n){
        int count = 0;
        for(int i = 3; i < n + 1; i++){
            if(is3(i)){
                count++;
            }
        }
        return count;
    }
}