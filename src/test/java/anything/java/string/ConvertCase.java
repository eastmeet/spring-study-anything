package anything.java.string;

import java.util.Scanner;

public class ConvertCase {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();

            StringBuilder sb = new StringBuilder();
            for (char c : input.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    c = Character.toLowerCase(c);
                } else {
                    c = Character.toUpperCase(c);
                }
                sb.append(c);
            }
            System.out.println(sb);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
