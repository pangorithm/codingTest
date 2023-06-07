class Solution {
    public String[] solution(String my_string) {
        my_string = my_string.replaceAll("[ ]+", " ");
        
        if(my_string.charAt(0) == ' '){
            my_string = my_string.replaceFirst(" ", "");
        }
        return my_string.split(" ");
    }
}