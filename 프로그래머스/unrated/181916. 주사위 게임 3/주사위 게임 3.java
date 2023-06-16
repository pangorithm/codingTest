class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] list = {a, b, c, d};
        int[][] dic = new int[4][2];
        int count = 0;
        loop : for(int num : list){
            for(int i = 0; i < dic.length; i++){
                if(num == dic[i][0]){
                    dic[i][1]++;
                    continue loop;
                } else if(dic[i][0] == 0){
                    break;
                }
            }
            dic[count][0] = num;
            dic[count++][1] = 1;
        }
        boolean nf = true;
        while(nf){
            nf = false;
            for(int i = 1; i < 4; i++){
                if(dic[i - 1][1] < dic[i][1]){
                    int[] temp = dic[i - 1];
                    dic[i - 1] = dic[i];
                    dic[i] = temp;
                    nf = true;
                }
            }
        }
        // for(int i = 0; i < 4; i++){
        //     System.out.printf("%d   %d\n", dic[i][0], dic[i][1]);
        // }
        if(dic[0][1] == 4){
            return a * 1111;
        }
        if(dic[0][1] == 3){
            return (10 * dic[0][0] + dic[1][0]) * (10 * dic[0][0] + dic[1][0]);
        }
        if(dic[0][1] == 2){
            if(dic[1][1] == 2){
                return (dic[0][0] + dic[1][0]) * Math.abs(dic[0][0] - dic[1][0]);
            } else {
                return dic[1][0] * dic[2][0];
            }
        }
        return Math.min(Math.min(a, b), Math.min(c, d));
        
    }
}