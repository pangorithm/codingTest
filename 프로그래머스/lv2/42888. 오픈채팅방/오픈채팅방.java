import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();        
        for(String str : record) {
            String[] arr = str.split(" ");
            if(arr[0].equals("Enter")){
                map.put(arr[1], arr[2]);               
                list.add(arr[1] + ",님이 들어왔습니다.");
            } else if(arr[0].equals("Change")){
                map.put(arr[1], arr[2]);
            } else {
                list.add(arr[1] + ",님이 나갔습니다.");
            }
        }
        
        String[] answer = list.toArray(new String[list.size()]);
        for(int i = 0; i < answer.length; i++){
            String[] arr = answer[i].split(",");
            answer[i] = map.get(arr[0]) + arr[1];
        }
        return answer;
    }
}