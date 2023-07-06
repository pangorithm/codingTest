import java.util.*;

class Solution {
    public int solution(String numbers) {
        char[] nums = numbers.toCharArray();
        Arrays.sort(nums);
        StringBuilder maxStr = new StringBuilder();
        for(char ch : nums){
            maxStr.insert(0, ch);
        }
        int max = Integer.parseInt(maxStr.toString());
        TreeSet<Integer> primeSet = new TreeSet<>();
        
        primeSet.add(2);
        
        loop : for(int nextPrime = 3; nextPrime <= Math.sqrt(max); nextPrime += 2){
            for(Integer p : primeSet.toArray(new Integer[primeSet.size()])){
                if(nextPrime % p == 0){
                    continue loop;
                }
            }                
        primeSet.add(nextPrime);
        }
        // System.out.println(max);
        // System.out.println(primeSet);
                
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        
        // System.out.println(set);
               
        int answer = 0;
        loop : for(Integer n : set.toArray(new Integer[set.size()])){ 
            if(n > 1){
                if(!primeSet.contains(n)){
                    for(Integer p : primeSet.toArray(new Integer[primeSet.size()])){
                        if(n % p == 0){
                            continue loop;
                        }
                    }  
                }
            // System.out.println(n);
            answer++;
            }
        }
        
        return answer;
    }
    
    void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")){ 
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++){
          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }
    }
}