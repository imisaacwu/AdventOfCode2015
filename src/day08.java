import java.util.List;

import lib.FileIO;

public class day08 {
    public static void main(String[] args) {
        List<String> input = FileIO.read("input/day08.in");

        int code = 0, mem = 0, enc = 0;
        for (String s : input) {
            code += s.length();

            String inMem = s;
            inMem = inMem.replaceAll("\\\\\\\\", "b");
            inMem = inMem.replaceAll("\\\\\\\"", "q");
            inMem = inMem.replaceAll("\\\\x[\\da-f]{2}", "x");
            inMem = inMem.replaceAll("\\\"", "");
            mem += inMem.length();

            String encoded = s;
            encoded = encoded.replaceAll("\\\\", "\\\\\\\\");
            encoded = encoded.replaceAll("\\\"", "\\\\\\\"");
            // For outer un-escaped quotes
            enc += encoded.length() + 2;
        }

        System.out.println("Day 08:");
        System.out.printf("Part 1: %d\n", code - mem);
        System.out.printf("Part 2: %d\n", enc - code);
    }
}