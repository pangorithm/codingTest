class Solution {
    int answer = Integer.MAX_VALUE;
    
    public int solution(String name) {
        removeChar(name, 0, 0);
        return answer;
    }
    
    void removeChar(String str, int index, int count){
        if(str.matches(".*[B-Z]+.*")){
            char[] chars = str.toCharArray();
            int forwardIndex = index;
            int fCount = 0;
            while(chars[forwardIndex % chars.length] == 'A'){
                forwardIndex++;
                fCount++;
            }
            forwardIndex %= chars.length;
            int changeCount = Math.min(chars[forwardIndex] - 'A', 'Z' - chars[forwardIndex] + 1);
            chars[forwardIndex] = 'A';
            removeChar(String.valueOf(chars), forwardIndex, 
                       count + fCount + changeCount);
                
            chars = str.toCharArray();
            int backwardIndex = index + chars.length;
            int bCount = 0;
            while(chars[backwardIndex % chars.length] == 'A'){
                backwardIndex--;
                bCount++;
            }
            backwardIndex = backwardIndex % chars.length;
            changeCount = Math.min(chars[backwardIndex] - 'A', 'Z' - chars[backwardIndex] + 1);
            chars[backwardIndex] = 'A';
            removeChar(String.valueOf(chars), backwardIndex, 
                       count + bCount + changeCount);
            
        } else {
            // System.out.println(str+" "+count);
            answer = Math.min(answer, count);
        }
    }
}