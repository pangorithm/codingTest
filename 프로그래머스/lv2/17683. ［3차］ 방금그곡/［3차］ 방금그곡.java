class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = replaceMelody(m);
        int maxPlayTime = 0;
        
        for(String str : musicinfos){
            String[] splited = str.split(","); // {start, end, title, sheet}
            splited[3] = replaceMelody(splited[3]);
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
    
    String replaceMelody (String melody){
        return melody
            .replaceAll("C#", "H")
            .replaceAll("D#", "I")
            .replaceAll("F#", "J")
            .replaceAll("G#", "K")
            .replaceAll("A#", "L");
    }
}