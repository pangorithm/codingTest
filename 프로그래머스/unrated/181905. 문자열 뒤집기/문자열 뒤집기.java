class Solution {
    public String solution(String my_string, int s, int e) {
        String substr = my_string.substring(s, e + 1);
        String[] strarr = substr.split("");
        substr = "";
        for(int i = strarr.length - 1; i > -1; i--){
            substr += strarr[i];
        }
        return my_string.substring(0, s).concat(substr).concat(my_string.substring(e + 1));
    }
}