class Solution {
    static int keySize;
    
    public boolean solution(int[][] key, int[][] lock) {
        keySize = key.length;
        
        for(int r = 0; r < 4; r++){
            for(int yMove = -lock.length; yMove <= lock.length; yMove++){
                loop : for(int xMove = -lock.length; xMove <= lock.length; xMove++){
                    for(int y = 0; y < lock.length; y++){
                        int nextY = y + yMove;
                        for(int x = 0; x < lock.length; x++){
                            int nextX = x + xMove;
                            if(lock[y][x] 
                               + (isValid(nextY) && isValid(nextX) ? key[nextY][nextX] : 0) 
                               != 1){
                                continue loop;
                            }
                        }
                    }
                    return true;
                }
            }
            
            if(r != 3){
                key = rotateKey(key);                
            }
        }
        
        return false;
    }
    
    boolean isValid(int z){
        if(z >= 0 && z < keySize){
            return true;
        } else {
            return false;
        }
    }
    
    int[][] rotateKey(int[][] key){
        int[][] newKey = new int[key.length][key.length];
        for(int i = 0; i < key.length; i++){
            for(int j = 0; j < key.length; j++){
                newKey[j][key.length - i - 1] = key[i][j];
            }
        }
        return newKey;
    }               
    // 0 1 2
    // 3 4 5
    // 6 7 8
    
    // 0 3 6
    // 1 4 7
    // 2 5 8
    
    // 6 3 0
    // 7 4 1
    // 8 5 2
}