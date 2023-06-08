class Solution {
    public int solution(int a, int b) {
        String astr = Integer.toString(a);
        String bstr = Integer.toString(b);
        String Astr = astr.concat(bstr);
        String Bstr = bstr.concat(astr);
        return Integer.parseInt(Astr) > Integer.parseInt(Bstr) ? Integer.parseInt(Astr) : Integer.parseInt(Bstr);
    }
}