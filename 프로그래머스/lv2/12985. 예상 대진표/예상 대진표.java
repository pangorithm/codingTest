class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        for(int i = 0; a != b; i++){
            a = (a + 1) >> 1;
            b = (b + 1) >> 1;
            answer = i + 1;
        }

        return answer;
    }
}