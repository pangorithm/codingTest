class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        for(int i = 0; i < queries.length; i++){
            int length = queries[i][1] - queries[i][0] + 1;
            char[] temp = new char[length];
            for(int j = 0; j < length; j++){
                temp[j] = my_string.charAt(queries[i][1] - j);
            }
            my_string = my_string.substring(0, queries[i][0])
                .concat(String.valueOf(temp))
                .concat(my_string.substring(queries[i][1] + 1));
        }
        return my_string;
    }
}