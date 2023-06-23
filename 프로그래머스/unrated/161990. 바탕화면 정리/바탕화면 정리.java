class Solution {
    public int[] solution(String[] wallpaper) {
        int[] s = {51, 51};
        int[] e = {0, 0};
        
        for(int i = 0; i < wallpaper.length; i++){
            char[] carr = wallpaper[i].toCharArray();
            for(int j = 0; j < carr.length; j++){
                if(carr[j] == '#'){
                    if(i < s[0]){
                        s[0] = i;
                    }
                    if(j < s[1]){
                        s[1] = j;
                    }
                    if(i > e[0]){
                        e[0] = i;
                    }
                    if(j > e[1]){
                        e[1] = j;
                    }
                }
            }
        }             
        
        int[] answer = {s[0], s[1], e[0] + 1, e[1] + 1};
        return answer;
    }
}