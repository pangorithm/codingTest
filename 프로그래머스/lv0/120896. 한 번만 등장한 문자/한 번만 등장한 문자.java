class Solution {
    public String solution(String s) {
        char[] charArr = s.toCharArray();
        boolean nf = true;
        while(nf){
            nf = false;
            for(int i = 1; i < charArr.length; i++){
                    char temp;
                if(charArr[i - 1] > charArr[i]){
                    temp = charArr[i - 1];
                    charArr[i - 1] = charArr[i];
                    charArr[i] = temp;
                    nf = true;
                }
            }
        }
        s = String.valueOf(charArr);
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) == s.charAt(i)){
                s = s.replaceAll(Character.toString(s.charAt(i)), "");
                i = 0;
            }
        }
        return s;
    }
}