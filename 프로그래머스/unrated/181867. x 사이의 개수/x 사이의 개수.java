class Solution {
    public int[] solution(String myString) {
        String[] strArr = myString.split("x");
        int length = (myString.charAt(myString.length() - 1) == 'x') ? strArr.length + 1 : strArr.length;
        int[] answer = new int[length];
        for(int i = 0; i < strArr.length; i++){
            answer[i] = strArr[i].length();
        }
        return answer;
    }
}