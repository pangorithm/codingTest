class Solution {
    public String solution(String my_string, int[][] queries) {
        for(int[] query : queries){
            char[] chars = my_string.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < query[0]; i++){
                sb.append(chars[i]);
            }
            for(int i = query[1]; i >= query[0]; i--){
                sb.append(chars[i]);
            }
            for(int i = query[1] + 1; i < chars.length; i++){
                sb.append(chars[i]);
            }
            my_string = sb.toString();
        }
        return my_string;
    }
}