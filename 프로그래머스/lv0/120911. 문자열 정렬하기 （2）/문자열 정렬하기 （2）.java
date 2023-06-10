class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        char[] charArr = my_string.toCharArray();
        boolean inf = true; 
        while(inf){
            inf = false;
            for(int i = 0; i < charArr.length -1; i++){
                if(charArr[i] > charArr[i + 1]){
                    char temp = charArr[i];
                    charArr[i] = charArr[i + 1];
                    charArr[i + 1] = temp;
                    inf = true;
                }
            }
        }
        return String.valueOf(charArr);
    }
}