class Solution {
    public int solution(String my_string) {
        String[] sa = my_string.split("[ ]+");
        int answer = Integer.parseInt(sa[0]);
        for(int i = 1; i < sa.length; i = i + 2){
            if(sa[i].equals("+")){
                answer += Integer.parseInt(sa[i + 1]);
            } else if(sa[i].equals("-")){
                answer -= Integer.parseInt(sa[i + 1]);
            }
        }
        return answer;
    }
}