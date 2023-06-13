class Solution {
    public String solution(String bin1, String bin2) {
        int sum = 0;
        for(int i = 0; i < bin1.length(); i++){
            if(bin1.charAt(bin1.length() - 1 - i) == '1'){
                sum += Math.pow(2, i);
            }
        }
        for(int i = 0; i < bin2.length(); i++){
            if(bin2.charAt(bin2.length() - 1 - i) == '1'){
                sum += Math.pow(2, i);
            }
        }
        return Integer.toBinaryString(sum);
    }
}