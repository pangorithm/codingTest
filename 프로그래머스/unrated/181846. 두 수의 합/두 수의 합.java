class Solution {
    public String solution(String a, String b) {
        int length = Math.max(a.length(), b.length()) + 1;
        int[] aca = new int[length];
        int[] bca = new int[length];
        int[] sca = new int[length];
        for(int i = 0; i < a.length(); i++){
            aca[i] = a.charAt(a.length() - 1 - i) - '0';
        }
        for(int i = 0; i < b.length(); i++){
            bca[i] = b.charAt(b.length() - 1 - i) - '0';
        }
        for(int i = 0; i < length - 1; i++){
            int sum = sca[i] + aca[i] + bca[i];
            sca[i] = sum % 10;
            sca[i + 1] = sum / 10;
        }
        
        String answer = "";
        for(int i = 0; i < length; i++){
            answer += sca[length - 1 - i];
        }
        if(answer.startsWith("0")){
            answer = answer.substring(1);
        }
        return answer;
    }
}