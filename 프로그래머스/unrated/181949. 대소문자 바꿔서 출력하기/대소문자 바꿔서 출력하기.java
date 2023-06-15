import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] ac = a.toCharArray();
        for(int i = 0; i < ac.length; i++){
            if(ac[i] < 'a'){
                ac[i] += 32;
            } else {
                ac[i] -= 32;
            }
        }
        System.out.println(String.valueOf(ac));
    }
}