class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder str = new StringBuilder();
        int[] lp = {0, 3}; // 왼손 초기 위치
        int[] rp = {2, 3}; // 오른손 초기 위치
        int[] x = new int[2];
        // {x = (num - 1) % 3, y = (num - 1) / 3}
        for(int num : numbers){
            switch (num) {
                case 1:
                case 4:
                case 7:
                    str.append("L");
                    lp[0] = (num - 1) % 3;
                    lp[1] = (num - 1) / 3;
                    break;
                case 3:
                case 6:
                case 9:
                    str.append("R");
                    rp[0] = (num - 1) % 3;
                    rp[1] = (num - 1) / 3;   
                    break;
                case 2:
                case 5:
                case 8:
                    x[0] = (num - 1) % 3;
                    x[1] = (num - 1) / 3;
                    if(closer(lp, rp, x).equals("left")){
                        str.append("L");    
                        lp[0] = (num - 1) % 3;
                        lp[1] = (num - 1) / 3;
                    } else if (closer(lp, rp, x).equals("right")){
                        rp[0] = (num - 1) % 3;
                        rp[1] = (num - 1) / 3;
                        str.append("R");
                    } else {
                        if(hand.equals("left")){
                            str.append("L");    
                            lp[0] = (num - 1) % 3;
                            lp[1] = (num - 1) / 3;
                        } else if (hand.equals("right")){
                            rp[0] = (num - 1) % 3;
                            rp[1] = (num - 1) / 3;
                            str.append("R");
                        }
                    }
                    break;
                case 0:
                    x[0] = 1;
                    x[1] = 3;
                    if(closer(lp, rp, x).equals("left")){
                        str.append("L");    
                        lp[0] = 1;
                        lp[1] = 3;
                    } else if (closer(lp, rp, x).equals("right")){
                        rp[0] = 1;
                        rp[1] = 3;
                        str.append("R");
                    } else {
                        if(hand.equals("left")){
                            str.append("L");    
                            lp[0] = 1;
                            lp[1] = 3;
                        } else if (hand.equals("right")){
                            rp[0] = 1;
                            rp[1] = 3;
                            str.append("R");
                        }
                    }
                    break;
            }
        }
        return str.toString();
    }
    
    String closer (int[] left, int[] right, int[] x){
        int ld = 
            Math.abs(left[0] - x[0]) +
            Math.abs(left[1] - x[1]);
        
        int rd = 
            Math.abs(right[0] - x[0]) +
            Math.abs(right[1] - x[1]);
        
        if(ld < rd){
            return "left";
        } else if (rd < ld){
            return "right";
        } else {
            return "equal";
        }
    }
}