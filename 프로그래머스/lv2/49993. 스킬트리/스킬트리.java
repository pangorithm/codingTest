import java.util.HashSet;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        HashSet<Character> set = new HashSet<>();
        for(char ch : skill.toCharArray()){
            set.add(ch);
        }
        int answer = 0;
        for(String skill_tree : skill_trees){
            char[] skills = skill_tree.toCharArray();
            StringBuilder strbd = new StringBuilder();
            for(int i = 0; i < skills.length; i++){
                if(set.contains(skills[i])){
                    strbd.append(skills[i]);
                }
            }
            if(skill.startsWith(strbd.toString())){
                answer++;
            }
        }
        return answer;
    }
}