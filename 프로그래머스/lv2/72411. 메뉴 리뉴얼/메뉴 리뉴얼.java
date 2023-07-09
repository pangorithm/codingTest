import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        TreeMap<String, HashSet> courseMap = new TreeMap<>(); // <코스, 주문한 손님 인덱스 집합>
        HashMap<Integer, Integer> maxCount = new HashMap<>(); // <코스 길이, 주문된 최대 횟수>
        
        for(int length : course){
            maxCount.put(length, 2);
        }
        
        for(int i = 0; i < orders.length; i++){
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            addCourse(String.valueOf(temp), courseMap, course[0], course[course.length - 1], i, maxCount);
        }
        // System.out.println(courseMap);
        
        // System.out.println(maxCount);
        
        HashMap<Integer, HashSet> resultMap = new HashMap<>(); // <코스길이, 주문한 손님 인덱스 집합>
        for(int length : course){
            resultMap.put(length, new HashSet<String>());
        }
        
        for(String str : courseMap.keySet()){
            int length = str.length();
            int count = courseMap.get(str).size();
            if(maxCount.containsKey(length)){
                if(count == maxCount.get(length)){
                    resultMap.get(length).add(str);
                }
            }
        }
        // System.out.println(resultMap);
        
        ArrayList<String> list = new ArrayList<>();
        for(int length : course){
            HashSet<String> temp = resultMap.get(length);
            for(String str : temp.toArray(new String[0])){
                list.add(str);
            }
        }
        String[] answer = list.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
    
    void addCourse (String course, TreeMap courseMap, int minSize, int maxSize, int index, HashMap<Integer, Integer> maxCount){
        int length = course.length();
        if(length <= maxSize){
            HashSet<Integer> set = (HashSet) courseMap.getOrDefault(course, new HashSet<Integer>());
            set.add(index);
            int size = set.size();
            if(maxCount.containsKey(length)){
                if(size > maxCount.get(length)){
                    maxCount.put(length, size);
                }
            }
            courseMap.put(course, set);
        }
        
        if(length > minSize){
            for(int i = 0; i < length; i++){
                addCourse(course.substring(0, i) + course.substring(i + 1), courseMap, minSize, maxSize, index, maxCount);
            }
        }
    }
    
}