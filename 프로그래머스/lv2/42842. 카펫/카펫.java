class Solution {
    public int[] solution(int brown, int yellow) {

        // 가로 + 세로 = 갈색 >> 1 + 2
        int h = 3;
        int w = (brown >> 1) + 2 - h;
        while((h * w != (brown + yellow)) || ((w - 2) * (h - 2) != yellow)){
            h++;
            w--;
        }
        int[] answer = {w, h};
        return answer;
    }
}