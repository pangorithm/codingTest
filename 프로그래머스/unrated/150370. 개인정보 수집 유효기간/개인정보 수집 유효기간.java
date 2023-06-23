import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //  1 <= dd <= 28 이기 때문에 int만으로 풀수도 있지만 LocalDate 클래스를 사용해보자
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate now = LocalDate.parse(today, formatter);
        
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str : terms){
            String[] splited = str.split(" ");
            map.put(splited[0], Integer.parseInt(splited[1]));
        }
        
        for(int i = 0; i < privacies.length; i++){
            String[] splited = privacies[i].split(" ");
            LocalDate expiration = LocalDate.parse(splited[0], formatter);
            expiration = expiration.plusMonths((int) map.get(splited[1]));
            if(expiration.compareTo(now) <= 0){
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}