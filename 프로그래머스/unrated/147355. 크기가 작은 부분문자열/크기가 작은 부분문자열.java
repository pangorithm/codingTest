class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        char[] pch = p.toCharArray();
        for(int i = 0; i < t.length() - pch.length + 1; i++){
            char[] tsubch = t.substring(i, i + pch.length).toCharArray();
            for(int j = 0; j < pch.length; j++){
                if(pch[j] < tsubch[j]){
                    break;
                } else if (pch[j] > tsubch[j]){
                    answer++;
                    break;
                } else if ((j == pch.length - 1) && (pch[j] == tsubch[j])){                    
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}