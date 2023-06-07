class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling) {
            while(str.length() != 0){
                if(str.startsWith("aya")){
                    str = str.replaceFirst("aya", "");
                } else if (str.startsWith("ye")){
                    str = str.replaceFirst("ye", "");
                } else if (str.startsWith("woo")){
                    str = str.replaceFirst("woo", "");
                } else if (str.startsWith("ma")){
                    str = str.replaceFirst("ma", "");
                } else {
                    break;
                }
            }
            if(str.length() == 0){
                answer++;
            }
        }
        return answer;
    }
}