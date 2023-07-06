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
        Queue<List> bfs = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i++){
            
            bfs.add(new ArrayList<Integer>(i));
        }
                
        while(bfs.size() != 0){
            List list = bfs.poll();
            
            if(list.contains(nums.length)){
                list.remove((Integer) nums.length);
                StringBuilder str = new StringBuilder();
                for(int i = 0; i < list.size(); i++){
                    str.append(nums[(int) list.get(i)]);
                }
                if(str.length() != 0){
                    set.add(Integer.parseInt(str.toString()));
                }
            } else {
                for(List nextList : getNextLists(list, nums.length)){
                    if(nextList != null){
                        bfs.offer(nextList);
                    }
                }
            }
            
            
        }
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
    
    List[] getNextLists (List<Integer> list, int numsLength){
        List[] nextLists = new List[numsLength + 1];
        for(int i = 0; i < numsLength; i++){
            if(!list.contains(i)){
                nextLists[i] = new ArrayList(list);
                nextLists[i].add(i);
            }
        }
        nextLists[numsLength] = list;
        nextLists[numsLength].add(numsLength);
        return nextLists;
    }
}