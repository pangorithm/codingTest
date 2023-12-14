class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int time = 1;
        int bandageStack = 0;
        for(int[] attack : attacks){
            while(time++ < attack[0]){
                hp += bandage[1];
                bandageStack++;
                if(bandageStack == bandage[0]){
                    hp += bandage[2];
                    bandageStack = 0;
                }
                hp = Math.min(hp, health);
            }
            bandageStack = 0;
            hp -= attack[1];
            if(hp <= 0){
                hp = -1;
                break;
            }
        }
        return hp;
    }
}