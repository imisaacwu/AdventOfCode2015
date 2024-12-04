import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lib.Coord;
import lib.Direction;
import lib.FileIO;

public class day03 {
    public static void main(String[] args) {
        char[] input = FileIO.read("input/day03.in").get(0).toCharArray();
    
        Set<Coord> houses = new HashSet<>(), houses_dual = new HashSet<>();
        Coord curr = new Coord(0, 0), santa = new Coord(0, 0), robo = new Coord(0, 0);
        houses.add(curr);
        houses_dual.add(santa);

        for(int i = 0; i < input.length; i++) {
            Map<Character, Direction> dir = Map.of(
                '^', Direction.N,
                'v', Direction.S,
                '>', Direction.E,
                '<', Direction.W
            );
            curr = curr.relative(dir.get(input[i]));
            houses.add(curr);

            if(i % 2 == 0) {
                santa = santa.relative(dir.get(input[i]));
                houses_dual.add(santa);
            } else {
                robo = robo.relative(dir.get(input[i]));
                houses_dual.add(robo);
            }
        }

        System.out.println("Day 03:");
        System.out.printf("Part 1: %d\n", houses.size());
        System.out.printf("Part 2: %d\n", houses_dual.size());
    }
}