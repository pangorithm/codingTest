class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0){
            int temp = storey % 10;
            storey /= 10;
            if(temp > 5 || ((temp >= 5) && ((storey % 10) >= 5))){
                storey += 1;
                temp = 10 - temp;
            }
            answer += temp;
            // System.out.println(answer);
        }
        return answer;
    }
}