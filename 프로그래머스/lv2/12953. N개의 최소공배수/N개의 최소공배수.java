import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[arr.length - 1];
        for(int i = 1; i < arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
    
    int lcm(int a, int b){
        return a * b / gcd(a, b);
    }
}