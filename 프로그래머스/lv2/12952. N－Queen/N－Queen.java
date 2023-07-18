class Solution {
    private static int[] board;
    private static int answer;

    public static int solution(int n) {
        board = new int[n]; // 인덱스는 행을 의미하고 값은 열을 의미

        backTracking(0, n); // n개 배치할 수 있는지 0개의 퀸을 배치한 상태부터 검색 시작

        return answer;
    }

    private static void backTracking(int depth, int n) {
        if (depth == n) { // n개 배치되었을 경우
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[depth] = i; // 배치된 퀸의 갯수 번째 행의 모든 열에 퀸 배치
                              // 결과적으로 0,0 부터 n-1, n-1 까지 모든 위치에 퀸을 배치 시도하게 된다.
            if (valid(depth)) { // 배치 가능한 경우
                backTracking(depth + 1, n); // 다음 단계 검사
            }
        }
    }

    private static boolean valid(int i) { // 퀸이 배치된 행을 의미
        for (int j = 0; j < i; j++) { // 배치된 행 이하의 다른 행을 의미
            if (board[i] == board[j]) return false; // 같은 열에 퀸이 배치된 경우
            if (Math.abs(i - j) == Math.abs(board[i] - board[j])) return false; 
            // 행의 차이와 열의 차이가 같다는 것은 같은 대각선에 위치함을 의미
        }
        return true;
    }
}