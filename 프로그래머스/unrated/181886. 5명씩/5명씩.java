class Solution {
    public String[] solution(String[] names) {
        int count = (names.length + 4) / 5;
        String[] answer = new String[count];
        for(int i = 0; i < count; i++){
            answer[i] = names[i * 5];
        }
        return answer;
    }
}