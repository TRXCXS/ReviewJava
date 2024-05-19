package String;

// 26 https://kamacoder.com/problempage.php?pid=1065

import java.util.Scanner;

public class RightHandedString {
    public static void reverseString(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String string = scanner.next();
        char[] s = string.toCharArray();

        reverseString(s, 0, s.length - 1);
        reverseString(s, 0, k - 1);
        reverseString(s, k, s.length - 1);
        System.out.println(new String(s));
        scanner.close();
    }
}
