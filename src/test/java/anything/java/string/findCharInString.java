package anything.java.string;

import java.util.Scanner;

public class findCharInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        char c = sc.nextLine().toLowerCase().charAt(0);
        System.out.println(solution(str, c));
    }

    public static int solution(String input1, char input2) {
        int count = 0;
        for (char c : input1.toCharArray()) {
            if (c == input2) {
                count++;
            }
        }
        return count;
    }
}
