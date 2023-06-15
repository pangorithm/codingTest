class Solution {
    public String solution(String polynomial) {
        polynomial = polynomial.replaceAll(" ", "");
        String[] strarr = polynomial.split("[+]");
        int x0 = 0;
        int x1 = 0;
        for(String str : strarr){
            if(str.contains("x")){
                if(str.equals("x")){
                    x1++;                    
                } else {
                    x1 += Integer.parseInt(str.replaceAll("x", ""));
                }
            } else {                
                x0 += Integer.parseInt(str);
            }
        }
        String s1 = "";
        String s0 = "";
        if(x1 > 0){
            if(x1 == 1){
                s1 = "x";
            } else {
                s1 = x1 + "x";
            }
        }
        
        if(x0 > 0){
            s0 += x0;
        }
        if((x1 > 0) && (x0 > 0)){
            return s1 + " + " + s0;
        } else if ((x1 == 0) && (x0 == 0)){
            return "";
        }else {
            return x1 > 0 ? s1 : s0;
        }
    }
}