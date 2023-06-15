class Solution {
    public String[] solution(String[] picture, int k) {
        for(int n = 0; n < picture.length; n++){
            char[] pic = picture[n].toCharArray();
            char[] temp = new char[picture[n].length() * k];
            for(int i = 0; i < pic.length; i++){
                for(int j = 0; j < k; j++){
                    temp[i * k + j] = pic[i];
                }
            }
            picture[n] = String.valueOf(temp);
        }
        String[] answer = new String[picture.length * k];
        for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < k; j++){
                answer[i * k + j] = picture[i];
            }
        }
        
        return answer;
    }
}