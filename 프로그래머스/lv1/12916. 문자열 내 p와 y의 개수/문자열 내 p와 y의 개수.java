class Solution {
    boolean solution(String s) {
        int pc = 0;
        int yc = 0;
        char[] carr = s.toLowerCase().toCharArray();
        for(char ch : carr){
            if(ch == 'p'){
                pc++;
            } else if(ch == 'y'){
                yc++;
            }
        }
        return pc == yc ? true : false;
    }
}