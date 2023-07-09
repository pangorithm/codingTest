class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum = 0;
        long checkSum = 0;
        int[] que = new int[queue1.length * 3];
        for(int i = 0; i < queue1.length; i++){
            que[i] = queue1[i];
            que[queue1.length + i] = queue2[i];
            que[(queue1.length << 1) + i] = queue1[i];
            sum += queue1[i] + queue2[i];            
            checkSum += queue1[i];
        }
        if((sum & 1) == 1){
            return -1;
        }
        
        int answer = 0;
        sum >>= 1;
        int start = 0;
        int end = queue1.length;
        while(start < (queue1.length << 1) && end < queue1.length * 3){
            if(checkSum == sum){
                return answer;
            } else if(checkSum < sum){
                checkSum += que[end];
                end++;
            } else if(checkSum > sum){
                checkSum -= que[start];
                start++;
            }
            
            answer++;
        }
        
        return -1;
    }
}