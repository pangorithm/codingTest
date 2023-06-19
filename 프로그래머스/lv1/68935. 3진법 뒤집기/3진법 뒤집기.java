class Solution {
    public int solution(int n) {
        StringBuilder str = new StringBuilder();
        while(n > 0){
            str.append(n % 3);
            n /= 3;
        }
        return Integer.parseInt(str.toString(), 3);
    }
}