class Solution {
    public int solution(String str1, String str2) {
        boolean checkBool = true;
        
        for(int i = 0; i < str2.length() - str1.length() + 1; i++){
            checkBool = true;
            for(int j = 0; j < str1.length(); j++){
                if(str2.charAt(i + j) != str1.charAt(j)){
                    checkBool = false;
                    break;
                }
            }
            if(checkBool){
                return 1;
            }
        }
        return 0;
    }
}