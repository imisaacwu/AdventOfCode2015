import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lib.FileIO;

public class day10 {
    public static void main(String[] args) {
        String input = FileIO.read("input/day10.in").get(0);
        final Pattern p = Pattern.compile("(\\d)\\1*");
        Matcher m;

        String input40 = "";
        for (int i = 1; i <= 50; i++) {
            StringBuilder next = new StringBuilder();
            m = p.matcher(input);

            while (m.find()) {
                next.append(m.group().length());
                next.append(m.group(1));
            }

            input = next.toString();

            if (i == 40) { input40 = input; }
        }

        System.out.println("Day 10:");
        System.out.printf("Part 1: %s\n", input40.length());
        System.out.printf("Part 2: %d\n", input.length());
    }
}