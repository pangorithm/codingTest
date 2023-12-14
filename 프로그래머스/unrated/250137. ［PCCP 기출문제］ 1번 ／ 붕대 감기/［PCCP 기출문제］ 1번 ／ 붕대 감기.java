class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int beforeAttackTime = 0;
        for(int[] attack : attacks){
            int timeDiff = attack[0] - beforeAttackTime - 1;
            beforeAttackTime = attack[0];
            hp += (timeDiff * bandage[1]) + ((timeDiff / bandage[0]) * bandage[2]);
            hp = Math.min(hp, health);
            hp -= attack[1];
            if(hp <= 0){
                hp = -1;
                break;
            }
        }
        return hp;
    }
}