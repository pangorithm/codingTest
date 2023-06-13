class Solution {
    public int[] solution(int n) {
        int x = 2;
        String str = "";
        while(n != 1){
            if(n % x == 0){
                n /= x;
                if(!str.contains(""+x)){
                    str += x + " ";
                    }
                x = 2;
            } else {
                x++;
            }
        }
        String[] strarr = str.split(" ");
        int[] answer = new int[strarr.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = Integer.parseInt(strarr[i]);
        }
        return answer;
    }
}