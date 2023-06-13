class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] sa = s.split(" ");
        for(int i = 0; i < sa.length; i++){
            if(sa[i].equals("Z")){
                answer -= Integer.parseInt(sa[i - 1]);
            } else {
                answer += Integer.parseInt(sa[i]);
            }
        }
        return answer;
    }
}