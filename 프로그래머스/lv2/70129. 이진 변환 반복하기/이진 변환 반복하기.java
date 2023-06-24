class Solution {
    static int btCount = 0;
    static int zeroCount = 0;
    
    public int[] solution(String s) {
        while(!s.equals("1")){
            s = btrance(s);            
            // System.out.println(s);
        }
        int[] answer = {btCount, zeroCount};
        return answer;
    }
    
    String btrance (String bstr){
        btCount++;
        char[] carr = bstr.toCharArray();
        int oneCount = 0;
        for(char ch : carr){
            if(ch == '1'){
                oneCount++;
            }
        }
        zeroCount+= carr.length - oneCount;
        return Integer.toBinaryString(oneCount);
    }
}