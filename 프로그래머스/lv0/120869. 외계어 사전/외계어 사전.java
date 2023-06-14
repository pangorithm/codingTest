class Solution {
    public int solution(String[] spell, String[] dic) {
        int[] count = new int[spell.length];
        loop : for(String word : dic){
            for(int i = 0; i < count.length; i++){
                count[i] = 0;
            }
            for(int i = 0; i < word.length(); i++){
                for(int j = 0; j < spell.length; j++){
                    if(word.charAt(i) == spell[j].charAt(0)){
                        count[j]++;
                    }
                }
            }
            for(int c : count){
                if(c != 1){
                    continue loop;
                }
            }
            return 1;
        }
        return 2;
    }
}