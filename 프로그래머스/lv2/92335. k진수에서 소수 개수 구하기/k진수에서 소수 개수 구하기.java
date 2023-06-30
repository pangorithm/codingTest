class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] arr = Integer.toString(n, k).replaceAll("0+", "0").split("0");
        if(arr.length == 0){
            return 0;
        }
        
        loop : for(String str : arr){
            long temp = Long.parseLong(str);
            if(temp < 2){
                continue;
            } else if(temp != 2 && (temp & 1) == 0){
                continue;
            }
            for(int i = 3; i <= Math.sqrt(temp); i += 2){
                if(temp % i == 0){
                    continue loop;
                }
            }
            answer++;
        }
        
        return answer;
    }
}