class Solution {
    public String solution(int q, int r, String code) {
        String str = "";
        for(int i = 0; i < code.length(); i++){
            if(i % q == r){
                str += code.charAt(i);
            }
        }
        return str;
    }
}