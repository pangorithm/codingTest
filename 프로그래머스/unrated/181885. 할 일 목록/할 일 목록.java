class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int count = 0;
        for(boolean fin : finished){
            if(fin == false){
                count++;
            }
        }
        String[] answer = new String[count];
        count = 0;
        for(int i = 0; i < finished.length; i++){
            if(finished[i] == false){
                answer[count] = todo_list[i];
                count++;
            }
        }
        return answer;
    }
}