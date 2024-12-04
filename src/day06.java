import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lib.Coord;
import lib.FileIO;
import lib.Grid;

public class day06 {
    public static void main(String[] args) {
        List<String> input = FileIO.read("input/day06.in");

        Grid<Light> g = new Grid<>(new ArrayList<>());
        for (int r = 0; r < 1000; r++) {
            List<Light> list = new ArrayList<>();
            for (int c = 0; c < 1000; c++) {
                list.add(new Light(r, c));
            }
            g.grid.add(list);
        }

        for (String s : input) {
            String[] instr = s.split(" ");
            int[] start = Arrays.stream(instr[instr[0].equals("toggle") ? 1 : 2].split(",")).mapToInt(c -> Integer.parseInt(c)).toArray();
            int[] end = Arrays.stream(instr[instr[0].equals("toggle") ? 3 : 4].split(",")).mapToInt(c -> Integer.parseInt(c)).toArray();
            for (int r = start[0]; r <= end[0]; r++) {
                for (int c = start[1]; c <= end[1]; c++) {
                    Light l = g.get(r, c);
                    if (instr[0].equals("toggle")) {
                        l.on = !l.on;
                        l.brightness += 2;
                    } else if (instr[1].equals("on")) {
                        l.on = true;
                        l.brightness += 1;
                    } else {
                        l.on = false;
                        l.brightness = Math.max(0, l.brightness - 1);
                    }
                }
            }
        }

        int lit = 0, bright = 0;
        for (int r = 0; r < g.getHeight(); r++) {
            for (int c = 0; c < g.getWidth(); c++) {
                if (g.get(r, c).on) { lit++; }
                bright += g.get(r, c).brightness;
            }
        }

        System.out.println("Day 06:");
        System.out.printf("Part 1: %d\n", lit);
        System.out.printf("Part 2: %d\n", bright);
    }

    static class Light extends Coord {
        boolean on = false;
        int brightness = 0;

        public Light(int r, int c) {
            super(r, c);
        }
    }
}