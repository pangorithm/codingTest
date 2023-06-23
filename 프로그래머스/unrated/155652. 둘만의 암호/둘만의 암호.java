import java.util.ArrayList;

class Solution {
    public String solution(String s, String skip, int index) {
        ArrayList<Character> list = new ArrayList<>();
        char[] skipChars = skip.toCharArray();
        
        loop : for(int i = 0; i < 26; i++){
            for(int j = 0; j < skipChars.length; j++){
                if(i + 'a' == skipChars[j]){
                    continue loop;
                }
            }
            list.add((char) (i + 'a'));
            // System.out.println((char) (i + 'a'));
        }
        
        StringBuilder str = new StringBuilder();
        char[] schars = s.toCharArray();
        
        for(char ch : schars){
            str.append(list.get((list.indexOf(ch) + index) % list.size()));
        }
        
        return str.toString();
    }
}