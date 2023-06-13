class Solution {
    public String solution(int q, int r, String code) {
        String str = "";
        for(int i = 0; i < (code.length() - r + q - 1) / q; i++){
            str += code.charAt(q * i + r);
        }
        return str;
    }
}