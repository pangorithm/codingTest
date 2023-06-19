class Solution {
    public String solution(int n) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++){
            if((i & 1) == 0){
                str.append('수');
             } else {
                str.append('박');
            }
        }
        return str.toString();
    }
}