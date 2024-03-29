// f(n) = 3f(n-2) + 2(f(n-4) + f(n-6) + f(n-8) + ... + f(2))
// 4f(n-2) - f(n-4)

class Solution {
    public int solution(int n) {
        long[] cache = new long[n + 1];
        cache[2] = 3;
        long sum = 0;

        for (int i = 4; i <= n; i += 2) {
            cache[i] = (cache[i - 2] * 3 + ((sum << 1) + 2)) % 1000000007L;
            sum += cache[i - 2];
        }

        return (int) cache[n];
    }
}