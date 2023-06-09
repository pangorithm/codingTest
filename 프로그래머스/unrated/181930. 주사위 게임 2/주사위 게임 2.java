class Solution {
    public int solution(int a, int b, int c) {
        int answer = 1;
        
        int sc = 0;
        if(a == b){
            sc++;
        }
        if(c == b){
            sc++;
        }
        if(a == c){
            sc++;
        }
        
        switch(sc){
            case 3:
                answer = a*a*a + b*b*b + c*c*c;
            case 1:
                answer *= a*a + b*b + c*c;
            case 0:
                answer *= a + b + c;
                break;
        }
        
        return answer;
    }
}