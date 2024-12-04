import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lib.FileIO;

public class day04 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String key = FileIO.read("input/day04.in").get(0);
        MessageDigest md = MessageDigest.getInstance("MD5");

        int five = Integer.MAX_VALUE, i = 0;
        while (true) {
            byte[] hash = md.digest((key + i).getBytes());
            if (hash[0] == 0 && hash[1] == 0 && (hash[2] & 0xFF) < 0x10) { five = Math.min(five, i); }
            if (hash[0] == 0 && hash[1] == 0 && hash[2] == 0) { break; }
            i++;
        }

        System.out.println("Day 04:");
        System.out.printf("Part 1: %s\n", five);
        System.out.printf("Part 2: %d\n", i);
    }
}