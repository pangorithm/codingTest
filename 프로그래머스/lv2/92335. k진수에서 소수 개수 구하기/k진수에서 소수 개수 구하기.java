import java.util.HashSet;

class Solution {
    public int solution(int n, int k) {
        String toK = Integer.toString(n, k).replaceAll("0+", "0");
        String[] arr = toK.split("0");
        if(arr.length == 0){
            return 0;
        }
        int max = 0;
        long[] plist = new long[arr.length];
        for(int i = 0; i < arr.length; i++){
            plist[i] = Long.parseLong(arr[i]);
            if(plist[i] > Integer.MAX_VALUE){
                max = 100;
            } else if(max < plist[i]){
                max = (int) plist[i];
            }
        }
        
        HashSet<Integer> primeSet = new HashSet<>();
        primeSet.add(2);
        loop : for(int i = 3; i <= (max); i += 2){
            for(int num : primeSet.toArray(new Integer[primeSet.size()])){
                if(i % num == 0){
                    continue loop;
                }
            }
            primeSet.add(i);
        }
        // System.out.println(primeSet);
        
        int answer = 0;
        
        loop : for(long num : plist){
            if(num > Integer.MAX_VALUE){
                for(int prime : primeSet.toArray(new Integer[primeSet.size()])){
                    if(num % prime == 0){
                        continue loop;
                    }
                }
                answer++;
            } else if(primeSet.contains((int)num)){
                answer++;
            }
        // System.out.println(num);
        }
        
        return answer;
    }
}