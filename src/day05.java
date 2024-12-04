import java.util.List;

import lib.FileIO;

public class day05 {
    public static void main(String[] args) {
        List<String> input = FileIO.read("input/day05.in");

        int nice = 0, nice2 = 0;
        for (String s : input) {
            if (s.matches(".*([a-z]{2}).*\\1.*") && s.matches(".*([a-z])[a-z]\\1.*")) {
                nice2++;
            }

            if (s.matches(".*(ab|cd|pq|xy).*")) { continue; }
            if (s.matches("(.*[aeiou].*){3,}$") && s.matches(".*([a-z])\\1.*")) {
                nice++;
            }            
        }

        System.out.println("Day 05:");
        System.out.printf("Part 1: %d\n", nice);
        System.out.printf("Part 2: %d\n", nice2);
    }
}