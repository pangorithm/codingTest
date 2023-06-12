class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int count = 0;
        int[] intArr = new int[intStrs.length];
        for(int i = 0; i < intStrs.length; i++){
            intArr[i] = Integer.parseInt(intStrs[i].substring(s, s + l));
            if(intArr[i] > k){
                count++;
            }
        }
        int[] answer = new int[count];
        count = 0;
        for(int i = 0; i < intArr.length; i++){
            if(intArr[i] > k){
                answer[count++] = intArr[i];
            }
        }
        return answer;
    }
}