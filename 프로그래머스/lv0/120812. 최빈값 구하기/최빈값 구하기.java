class Solution {
    public int solution(int[] array) {
        int[][] dic = new int[100][2];
        int length = 0;
        int maxcount = 0;
        int max = -1;
        loop : for(int num : array){
            for(int i = 0; i < length; i++){
                if(dic[i][0] == num){
                    dic[i][1]++;
                    if(dic[i][1] > maxcount){
                        maxcount = dic[i][1];
                    }
                    continue loop;
                }
            }
            dic[length][0] = num;
            dic[length][1]++;
            if(dic[length][1] > maxcount){
                maxcount = dic[length][1];
            }
            length++;
        }
        int count = 0;
        for(int i = 0; i < length; i++){
            if(dic[i][1] == maxcount){
                max = dic[i][0];
                count++;
            }
            if(count > 1){
                return -1;
            }
        }
        return max;
    }
}