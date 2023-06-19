class Solution {
    public boolean solution(String s) {
        char[] carr = s.toCharArray();
        if(carr.length == 4 || carr.length == 6){
            for(char c : carr){
                if(c > '9'){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}