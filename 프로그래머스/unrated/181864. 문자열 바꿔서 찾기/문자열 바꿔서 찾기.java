class Solution {
    public int solution(String myString, String pat) {
        return myString.replaceAll("A", "b").replaceAll("B", "a").toUpperCase().contains(pat) ? 1 : 0;
    }
}