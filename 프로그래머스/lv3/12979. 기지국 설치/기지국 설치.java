class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int cursor = stations[0];
        while(cursor > w + 1){
            cursor -= (w << 1) + 1;
            answer++;
        }
        for(int i = 1; i < stations.length; i++){
            cursor = stations[i];
            while(cursor - stations[i - 1] > (w << 1) + 1){
                cursor -= (w << 1) + 1;
                answer++;
            }
        }
        cursor = stations[stations.length - 1] ;
        while(n - cursor > w){
            cursor += (w << 1) + 1;
            answer++;
        }
        
        return answer;
    }
}