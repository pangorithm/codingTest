class Solution {
    public String solution(int q, int r, String code) {
        char[] ca = new char[((code.length() - r + q - 1) / q)];
        char[] codeArr = code.toCharArray();
        for(int i = 0; i < ca.length; i++){
            if((q * i + r) < codeArr.length){
                ca[i] = codeArr[q * i + r];
            }
        }
        return String.valueOf(ca);
    }
}