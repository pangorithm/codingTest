import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        int zeroCount = 0;
        int oneCount = 0;
        int startY = 0;
        int startX = 0;
        for(int n = arr.length; n > 0; n >>= 1){
            for(int i = 0; i * n < arr.length; i++){
                startY = i * n;
                loop : for(int j = 0; j * n < arr.length; j++){
                    startX = j * n;
                    for(int y = startY; y < startY + n; y++){
                        for(int x = startX; x < startX + n; x++){
                            if(arr[startY][startX] != arr[y][x]){
                                continue loop;
                            }
                        }
                    }
                    
                    if(arr[startY][startX] == 0){
                        if(n > 1){
                            zeroCount -= 4;
                        }
                        zeroCount++;
                    } else {
                        if(n > 1){
                            oneCount -= 4;
                        }
                        oneCount++;
                    }
                }
            }
        }
        
        int[] answer = {zeroCount, oneCount};
        return answer;
    }
}