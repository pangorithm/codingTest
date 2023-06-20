class Solution {
    public int solution(int a, int b, int n) {
        return n < a ? 0 : (n / a) * b + solution(a, b, (n / a) * b + (n % a));
    }
}