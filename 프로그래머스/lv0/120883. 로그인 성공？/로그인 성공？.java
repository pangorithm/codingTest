class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for(String[] ck : db){
            if(id_pw[0].equals(ck[0])){
                if(id_pw[1].equals(ck[1])){
                    return "login";
                }
                return "wrong pw";
            }
        }
        return "fail";
    }
}