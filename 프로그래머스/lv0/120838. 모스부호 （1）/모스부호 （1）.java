class Solution {
    public String solution(String letter) {
        String[] morse = "'.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f','--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l','--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r','...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x','-.--':'y','--..':'z'".split(",");
        String[][] morseArray = new String[morse.length][2];
        for(int i = 0; i < morse.length; i++){
            morse[i] = morse[i].replaceAll("'", "");
            morseArray[i] = morse[i].split(":");
        }
        
        StringBuilder answer = new StringBuilder();
        
        String[] letterArr = letter.split(" ");
        loop : for(int i = 0; i < letterArr.length; i++){
            for(int j = 0; j < morseArray.length; j++){
                if(letterArr[i].equals(morseArray[j][0])){
                    answer.append(morseArray[j][1]);
                    continue loop;
                }
            }
        }
        
        return answer.toString();
    }
}