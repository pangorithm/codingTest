import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        HashSet<Loc> interSet = new HashSet<>();
        for(int i = 0; i < line.length; i++){
            for(int j = i + 1; j < line.length; j++){
                long numerator = (long) line[j][0] * (long) line[i][2] - (long) line[i][0] * (long) line[j][2];
                long denominator = (long) line[i][0] * (long) line[j][1] - (long) line[j][0] * (long) line[i][1];
                if(denominator == 0l){ // 평행
                    continue;
                }
                if(numerator % denominator == 0l){
                    long y = numerator / denominator;
                    numerator = (long) line[i][1] * line[j][2] - (long) line[j][1] * line[i][2];
                    if(numerator % denominator == 0l){
                        long x = numerator / denominator;
                        Loc loc = new Loc(y, x);
                        if(!interSet.contains(loc)){
                            interSet.add(loc);
                            minX = Math.min(minX, loc.x);
                            maxX = Math.max(maxX, loc.x);
                            minY = Math.min(minY, loc.y);
                            maxY = Math.max(maxY, loc.y);
                        }
                    }
                }
            }
        }
        
        char[][] plane = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
        for(int i = 0; i < plane.length; i++){
            for(int j = 0; j < plane[0].length; j++){
                plane[i][j] = '.';
            }
        }
        
        for(Loc loc : interSet.toArray(new Loc[interSet.size()])){ 
            // System.out.println(loc.y +" "+ loc.x); // 교점 목록 확인
            plane[(int) (maxY - loc.y)][(int) (loc.x - minX)] = '*';
        }
        
        String[] answer = new String[plane.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = String.valueOf(plane[i]);
        }
        
        return answer;
    }
    
    class Loc{
        long y;
        long x; 
        
        Loc(long y, long x){
            this.y = y;
            this.x = x;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;
            
            return this.y == ((Loc) obj).y && this.x == ((Loc) obj).x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.y + this.x);
        }
    }
} 