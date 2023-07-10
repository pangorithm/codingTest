class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;
        for(String str : musicinfos){
            String[] splited = str.split(","); // {start, end, title, sheet}
            splited[3] = splited[3]
                .replaceAll("C#", "H")
                .replaceAll("D#", "I")
                .replaceAll("F#", "J")
                .replaceAll("G#", "K")
                .replaceAll("A#", "L");
            m = m
                .replaceAll("C#", "H")
                .replaceAll("D#", "I")
                .replaceAll("F#", "J")
                .replaceAll("G#", "K")
                .replaceAll("A#", "L");
            String[] start = splited[0].split(":");
            String[] end = splited[1].split(":");
            int playTime = (Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1])) 
                - (Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]));
            String playedMelody = splited[3]
                .repeat((playTime / splited[3].length()) + 1)
                .substring(0, playTime);
            // System.out.println(playedMelody);
            if(playedMelody.contains(m)){
                if(playTime > maxPlayTime){
                    answer = splited[2];
                    maxPlayTime = playTime;
                }
            }
                
        }
        return answer;
    }
}