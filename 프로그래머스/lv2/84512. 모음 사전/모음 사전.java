import java.util.Arrays;
import java.util.TreeSet;

class Solution {
    public int solution(String word) {
        TreeSet<String> tree = new TreeSet<>();
        int index = 0;
        char[] chs = {' ', 'A', 'E', 'I', 'O', 'U'};
        for(char a : chs){
            for(char b : chs){
                for(char c : chs){
                    for(char d : chs){
                        for(char e : chs){
                            StringBuilder strbuild = new StringBuilder();
                            strbuild.append(a)
                                .append(b)
                                .append(c)
                                .append(d)
                                .append(e);
                            String str = strbuild.toString().replaceAll(" ", ""); 
                            tree.add(str);
                        }
                    }
                }
            }
        }
        String[] arr = new String[tree.size()];
        tree.toArray(arr);
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(word)){
                return i;
            }
        }
        
        return 0;
    }
}