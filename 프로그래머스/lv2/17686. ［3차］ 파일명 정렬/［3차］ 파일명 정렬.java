import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        FileName[] arr = new FileName[files.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new FileName(files[i], i);
        }
        
        Comparator<FileName> comparator = Comparator
            .comparing(FileName::getHead, String.CASE_INSENSITIVE_ORDER)
            .thenComparingInt(FileName::getNumber)
            .thenComparingInt(FileName::getIndex);
        Arrays.sort(arr, comparator);
        
        String[] answer = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            answer[i] = files[arr[i].index];
        }
        
        return answer;
    }
    
    class FileName {
        String head;
        int number;
        String tail;
        int index;
        
        FileName(String str, int index) { 
            int length = str.length();
            char[] arr = str.toCharArray();
            int i = 0;
            StringBuilder head = new StringBuilder();
            while(i < length && (arr[i] < '0' || arr[i] > '9')){
                head.append(arr[i++]);
            }
            StringBuilder number = new StringBuilder();
            while(i < length && arr[i] >= '0' && arr[i] <= '9'){
                number.append(arr[i++]);
            }
            StringBuilder tail = new StringBuilder();
            while(i < length){
                tail.append(arr[i++]);
            }            
            
            this.head = head.toString();
            this.number = Integer.parseInt(number.toString());
            this.tail = tail.toString();
            this.index = index;            
        }
        
        public String getHead() {
            return this.head;
        }

        public int getNumber() {
            return this.number;
        }

        public int getIndex() {
            return this.index;
        }
    }
}