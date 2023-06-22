class Solution {
    public int solution(String[] babbling) {
        int answer = babbling.length;
        loop : for(int i = 0; i < babbling.length; i++){
            babbling[i] = babbling[i]
                .replaceAll("aya","1")
                .replaceAll("ye","2")
                .replaceAll("woo","3")
                .replaceAll("ma","4");
                
            // if(babbling[i].contains("[^1-4]")){
            //     answer--;
            // }
            // System.out.println(babbling[i]);
            char[] babb = babbling[i].toCharArray();

            for(int j = 0; j < babb.length - 1; j++){
                if(babb[j] == babb[j + 1] || babb[j] > '4'){
                    answer--;
                    continue loop;
                }
            }
            if(babb[babb.length - 1] > '4'){
                answer--;
            }
        }
        
        return answer;
    }
}