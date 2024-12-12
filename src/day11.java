import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lib.FileIO;

public class day11 {
    public static void main(String[] args) {
        String input = FileIO.read("input/day11.in").get(0);

        while (!valid(input)) {
            input = increment(input);
        }

        System.out.println("Day 11:");
        System.out.printf("Part 1: %s\n", input);

        do {
            input = increment(input);
        } while (!valid(input));

        System.out.printf("Part 2: %s\n", input);
    }

    static boolean valid(String pass) {
        Pattern p1 = Pattern.compile("[iol]");
        Pattern p2 = Pattern.compile("([a-z])\\1.*([^\\\\1])\\2");
        Pattern p3 = Pattern.compile("abc|bcd|cde|def|efg|fgh|ghi|hij|ijk|jkl|klm|lmn|mno|nop|opq|pqr|qrs|rst|stu|tuv|uvw|vwx|wxy|xyz");
        Matcher m1 = p1.matcher(pass);
        Matcher m2 = p2.matcher(pass);
        Matcher m3 = p3.matcher(pass);
        return !m1.find() && m2.find() && m3.find();
    }

    static String increment(String str) {
        char[] chars = str.toCharArray();
        boolean carry = true;

        for (int i = chars.length - 1; i >= 0 && carry; i--) {
            if (chars[i] < 'z') {
                chars[i]++;
                carry = false;
            } else {
                chars[i] = 'a';
            }
        }

        return new String(chars);
    }
}