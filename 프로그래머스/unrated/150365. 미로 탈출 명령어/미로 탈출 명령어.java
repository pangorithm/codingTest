class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // d l r u
        int rowDis = Math.abs(r - x);
        int colDis = Math.abs(c - y);
        int dis = rowDis + colDis;
        int restDis = k - dis;
        
        if(restDis < 0 || (restDis & 1) == 1){
            return "impossible";
        }
        
        int row = x;
        int col = y;
        StringBuilder answer = new StringBuilder();
        while(dis <= k && row < n){
            answer.append("d");
            k--;
            row++;
            rowDis = Math.abs(r - row);
            dis = rowDis + colDis;
        }
        if(dis > k){
            answer.delete(answer.length() - 1, answer.length());
            k++;
            row--;
            rowDis = Math.abs(r - row);
            dis = rowDis + colDis;
        }
        while(dis <= k && col > 1){
            answer.append("l");
            k--;
            col--;
            colDis = Math.abs(c - col);
            dis = rowDis + colDis;
        }
        if(dis > k){
            answer.delete(answer.length() - 1, answer.length());
            k++;
            col++;            
            colDis = Math.abs(c - col);
            dis = rowDis + colDis;
        }
        
        while(dis < k){
            answer.append("rl");
            k -= 2;
        }
        
        answer.append("r".repeat(c - col));
        answer.append("u".repeat(row - r));
            
        return answer.toString();
    }
}