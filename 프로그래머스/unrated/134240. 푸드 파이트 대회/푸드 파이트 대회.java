class Solution {
    public String solution(int[] food) {
        StringBuilder str = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            int n = food[i] >> 1;
            for(int j = 0; j < n; j++){
                str.append(i);
            }
        }
        StringBuilder temp = new StringBuilder(str);
        return temp.append(0).append(str.reverse()).toString();
    }
}