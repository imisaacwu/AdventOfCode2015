import lib.FileIO;

public class day01 {
    public static void main(String[] args) {
        char[] input = FileIO.read("input/day01.in").get(0).toCharArray();

        int floor = 0, pos = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') { floor++; }
            else { floor--; }
            if (floor < 0) {
                pos = Math.min(pos, i + 1);
            }
        }


        System.out.println("Day 01:");
        System.out.printf("Part 1: %d\n", floor);
        System.out.printf("Part 2: %d\n", pos);
    }
}