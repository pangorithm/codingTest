class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        char[] chs = cantor(n,l - 1,r - 1).toCharArray();
        for(char ch : chs){
            if(ch == '1'){
                answer++;
            }
        }
        return answer;
    }
    
    String cantor(int n, long l, long r){
        if(n == 0){
            return "1";
        }
        String str =  cantor(n - 1, l / 5, r / 5).replaceAll("0", "00000").replaceAll("1", "11011");                   return str.substring((int) (l % 5), str.length() - (5 - (int) (r % 5)) + 1);
    }
}

// 1
// 11011
// 11011 11011 00000 11011 11011
