class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling) {
            str = str.replaceAll("aya", " ");
            str = str.replaceAll("ye", " ");
            str = str.replaceAll("woo", " ");
            str = str.replaceAll("ma", " ");
            str = str.replaceAll(" ", "");
            
            if(str.length() == 0){
                answer++;
            }
        }
        return answer;
    }
}