class Solution {
    public int solution(String A, String B) {
        int length = A.length();
        for(int i = 0; i < length; i++){
            if(B.equals(A.substring(length - i).concat(A.substring(0, length - i)))){
                return i;
            }
        }
        return -1;
    }
}