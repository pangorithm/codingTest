class Solution {
    public int solution(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[^0-9]", " ").replaceAll("[ ]+"," ");
        if(my_string.equals(" ")){
            return 0;
        }
        else if(my_string.charAt(0) == ' '){
            my_string = my_string.replaceFirst(" ", "");
        }
        String[] num_list = my_string.split(" ");
        for(String num : num_list){
            answer += Integer.parseInt(num);
        }
        return answer;
    }
}