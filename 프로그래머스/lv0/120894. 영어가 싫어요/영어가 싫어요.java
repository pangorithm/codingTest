class Solution {
    public long solution(String numbers) {
        String str = "";
        while(numbers.length() > 0){
            if(numbers.startsWith("zero")){
                str += 0;
                numbers = numbers.substring(4);
            } else if(numbers.startsWith("one")){
                str += 1;
                numbers = numbers.substring(3);
            } else if(numbers.startsWith("two")){
                str += 2;
                numbers = numbers.substring(3);
            } else if(numbers.startsWith("three")){
                str += 3;
                numbers = numbers.substring(5);
            } else if(numbers.startsWith("four")){
                str += 4;
                numbers = numbers.substring(4);
            } else if(numbers.startsWith("five")){
                str += 5;
                numbers = numbers.substring(4);
            } else if(numbers.startsWith("six")){
                str += 6;
                numbers = numbers.substring(3);
            } else if(numbers.startsWith("seven")){
                str += 7;
                numbers = numbers.substring(5);
            } else if(numbers.startsWith("eight")){
                str += 8;
                numbers = numbers.substring(5);
            } else if(numbers.startsWith("nine")){
                str += 9;
                numbers = numbers.substring(4);
            }
        }
        return Long.parseLong(str);
    }
}