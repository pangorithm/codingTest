class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int length = 0;
        switch (n) {
            case 1:
                length = slicer[1] + 1;
                break;
            case 2:
                length = num_list.length - slicer[0];
                break;
            case 3:
                length = slicer[1] - slicer[0] + 1;
                break;
            case 4: 
                length = (slicer[1] - slicer[0] + slicer[2]) / slicer[2];
                break;
        }
        int[] answer = new int[length];
        switch (n) {
            case 1:
                for(int i = 0; i < length; i++){
                    answer[i] = num_list[i];
                }
                break;
            case 2:
                for(int i = 0; i < length; i++){
                    answer[i] = num_list[slicer[0] + i];
                }
                break;
            case 3:
                for(int i = 0; i < length; i++){
                    answer[i] = num_list[slicer[0] + i];
                }
                break;
            case 4: 
                for(int i = 0; i < length; i++){
                    answer[i] = num_list[slicer[0] + i * slicer[2]];
                }
                break;
        }
        return answer;
    }
}