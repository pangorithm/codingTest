class Solution {
    public int solution(int number, int n, int m) {
        if(((number % n) | (number % m)) == 0){
            return 1;
        }
        return 0;
    }
}