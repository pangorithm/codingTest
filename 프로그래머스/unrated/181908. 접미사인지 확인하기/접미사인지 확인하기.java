class Solution {
    public int solution(String my_string, String is_suffix) {
        return my_string.startsWith(is_suffix, my_string.length() - is_suffix.length()) ? 1 : 0;
    }
}