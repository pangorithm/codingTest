class Solution {
    public String[] solution(String myStr) {
        myStr = myStr.replaceAll("[abc]", " ").replaceAll("[ ]+"," ");
        if(myStr.charAt(0) == ' '){
            myStr = myStr.replaceFirst(" ", "");
        }
        if(myStr.length() == 0){
            myStr = "EMPTY";
        }
        return myStr.split(" ");
    }
}