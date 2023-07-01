class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder strbd = new StringBuilder();
        int num = 0;
        String numstr = Integer.toString(num, n);
        int index = 0;
        int count = 0;
        while(strbd.length() != t){
            if(index < numstr.length()){
                if((count++ % m) == (p - 1)){
                    strbd.append(Character.toUpperCase(numstr.charAt(index++)));
                } else {
                    index++;
                }
            } else {
                numstr = Integer.toString(++num, n);
                index = 0;
            }
        }
        
        return strbd.toString();
    }
}