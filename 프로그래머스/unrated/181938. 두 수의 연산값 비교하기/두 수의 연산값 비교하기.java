class Solution {
    public int solution(int a, int b) {
        int x = Integer.parseInt(Integer.toString(a).concat(Integer.toString(b)));
        int y = 2 * a * b;
        return x < y ? y : x;
    }
}