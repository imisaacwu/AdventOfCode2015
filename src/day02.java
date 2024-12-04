import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lib.FileIO;

public class day02 {
    public static void main(String[] args) {
        List<String> input = FileIO.read("input/day02.in");

        List<Box> boxes = new ArrayList<>();
        for(String s : input) {
            boxes.add(new Box(Arrays.stream(s.split("x")).mapToInt(c -> Integer.parseInt(c)).toArray()));
        }

        int paper = 0, ribbon = 0;
        for(Box b : boxes) {
            paper += b.SA() + b.slack();
            ribbon += b.wrap() + b.bow();
        }

        System.out.println("Day 02:");
        System.out.printf("Part 1: %d\n", paper);
        System.out.printf("Part 2: %d\n", ribbon);
    }

    static class Box {
        int l, w, h;

        public Box(int[] dim) {
            this.l = dim[0];
            this.w = dim[1];
            this.h = dim[2];
        }

        public int SA() {
            return 2*l*w + 2*w*h + 2*h*l;
        }

        public int slack() {
            int[] arr = new int[]{l, w, h};
            Arrays.sort(arr);
            return arr[0] * arr[1];
        }

        public int wrap() {
            int[] arr = new int[]{l, w, h};
            Arrays.sort(arr);
            return 2 * arr[0] + 2 * arr[1];
        }

        public int bow() {
            return l*w*h;
        }
    }
}