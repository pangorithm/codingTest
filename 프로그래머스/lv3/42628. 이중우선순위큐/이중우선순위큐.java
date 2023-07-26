import java.util.*;

class Solution {
    public int[] solution(String[] operations) {        
        ArrayList<Integer> list = new ArrayList<>();
        for(String oper : operations){
            String[] splited = oper.split(" ");
            switch (splited[0]){
                case "I" :
                    list.add(Integer.parseInt(splited[1]));
                    Collections.sort(list);
                    break;
                case "D":
                    if(list.size() > 0){
                        switch (splited[1]){
                            case "1" :
                                list.remove(list.size() - 1);
                                break;
                            case "-1":
                                list.remove(0);
                                break;
                        }
                    }
                    break;
            }
        }
        int[] answer = new int[2];
        if(list.size() > 0){
            answer[0] = list.get(list.size() - 1);
            answer[1] = list.get(0);
        }
        
        return answer;
    }
}