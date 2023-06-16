class Solution {
    public int solution(int[][] lines) {
        // System.out.println(inter(lines[0], lines[1]));
        // System.out.println(inter(lines[1], lines[2]));
        // System.out.println(inter(lines[2], lines[0]));
        // System.out.println(inter(lines[0], lines[1], lines[2]));
        return inter(lines[0], lines[1]) 
            + inter(lines[1], lines[2]) 
            + inter(lines[2], lines[0]) 
            - (inter(lines[0], lines[1], lines[2]) << 1);
    }
    
    int inter(int[] a, int[] b){
        int start = Math.max(a[0], b[0]);
        int end = Math.min(a[1], b[1]);
        if(start < end){
            return end - start;
        } else {
            return 0;
        }
    }
        int inter(int[] a, int[] b, int[] c){
        int start = Math.max(Math.max(a[0], b[0]), c[0]);
        int end = Math.min(Math.min(a[1], b[1]), c[1]);
        if(start < end){
            return end - start;
        } else {
            return 0;
        }
    }
}