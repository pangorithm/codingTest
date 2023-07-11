class Solution {
    public String solution(String w) {
        if(w.equals("")){ // 1
            return "";
        }
        char[] warr = w.toCharArray();
        int count = 0;
        int i = 0;
        do { // 2
            if(warr[i] == '('){
                count++;
            } else {
                count--;
            }
            i++;
        } while(i < warr.length && count != 0);        
        String u = w.substring(0, i);
        String v = w.substring(i);
        // System.out.println(u + " & " + v);
        
        if(warr[0] == '('){ // 3
            return u + solution(v);
        } else {
            char[] uarr = u.toCharArray();
            StringBuilder newU = new StringBuilder();
            for(int j = 1; j < u.length() - 1; j++){
                if(uarr[j] == '('){
                    newU.append(")");
                } else {                    
                    newU.append("(");
                }
            }
            return "(" + solution(v) + ")" + newU.toString();            
        }
    }
}