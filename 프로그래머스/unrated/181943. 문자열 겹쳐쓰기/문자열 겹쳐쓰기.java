class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] mc = my_string.toCharArray();
        char[] oc = overwrite_string.toCharArray();
        for(int i = 0; i < oc.length; i++){
            mc[s + i] = oc[i];
        }
        return String.valueOf(mc);
    }
}