package String;

// 24 https://kamacoder.com/problempage.php?pid=1064

import java.util.Scanner;

public class ReplaceNumbers {
    // 卡码网类名必须使用Main，且不可出现"package String;"

    public static String replaceNumbers(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                result.append("number");
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(replaceNumbers(s));
        scanner.close();
    }
}
