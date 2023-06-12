class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] strArr = letter.split(" ");
        for(int i = 0; i < strArr.length; i++){
            if(strArr[i].equals(".-")){
                answer = answer.concat("a");
            } else if(strArr[i].equals("-...")){
                answer = answer.concat("b");
            } else if(strArr[i].equals("-.-.")){
                answer = answer.concat("c");
            } else if(strArr[i].equals("-..")){
                answer = answer.concat("d");
            } else if(strArr[i].equals(".")){
                answer = answer.concat("e");
            } else if(strArr[i].equals("..-.")){
                answer = answer.concat("f");
            } else if(strArr[i].equals("--.")){
                answer = answer.concat("g");
            } else if(strArr[i].equals("....")){
                answer = answer.concat("h");
            } else if(strArr[i].equals("..")){
                answer = answer.concat("i");
            } else if(strArr[i].equals(".---")){
                answer = answer.concat("j");
            } else if(strArr[i].equals("-.-")){
                answer = answer.concat("k");
            } else if(strArr[i].equals(".-..")){
                answer = answer.concat("l");
            } else if(strArr[i].equals("--")){
                answer = answer.concat("m");
            } else if(strArr[i].equals("-.")){
                answer = answer.concat("n");
            } else if(strArr[i].equals("---")){
                answer = answer.concat("o");
            } else if(strArr[i].equals(".--.")){
                answer = answer.concat("p");
            } else if(strArr[i].equals("--.-")){
                answer = answer.concat("q");
            } else if(strArr[i].equals(".-.")){
                answer = answer.concat("r");
            } else if(strArr[i].equals("...")){
                answer = answer.concat("s");
            } else if(strArr[i].equals("-")){
                answer = answer.concat("t");
            } else if(strArr[i].equals("..-")){
                answer = answer.concat("u");
            } else if(strArr[i].equals("...-")){
                answer = answer.concat("v");
            } else if(strArr[i].equals(".--")){
                answer = answer.concat("w");
            } else if(strArr[i].equals("-..-")){
                answer = answer.concat("x");
            } else if(strArr[i].equals("-.--")){
                answer = answer.concat("y");
            } else if(strArr[i].equals("--..")){
                answer = answer.concat("z");
            }
        }
        return answer;
    }
}