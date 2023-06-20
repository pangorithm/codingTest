import java.util.Date;

class Solution {
    public String solution(int a, int b) {
        Date date = new Date(2016, 1, 1);
        String[] dayOfWeek = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] monthOfDay = {31,29,31,30,31,30,31,31,30,31,30,31};
        int dif = b - 1;
        for(int i = 0; i < a - 1; i++){
            dif += monthOfDay[i];
        }
       
        return dayOfWeek[(5 + dif) % 7];
    }
}