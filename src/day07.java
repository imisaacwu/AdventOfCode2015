import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lib.FileIO;

public class day07 {
    public static void main(String[] args) {
        List<String> input = FileIO.read("input/day07.in");

        Map<String, String> defs = new HashMap<>();
        for (String s : input) {
            String[] kv = s.split(" -> ");
            defs.put(kv[1], kv[0]);
        }

        int a = findValue(new HashMap<>(defs), "a");
        defs.put("b", ""+a);
        int ba = findValue(new HashMap<>(defs), "a");

        System.out.println("Day 07:");
        System.out.printf("Part 1: %d\n", a);
        System.out.printf("Part 2: %d\n", ba);
    }

    static Integer findValue(Map<String, String> map, String target) {
        if (target.matches("\\d+")) { return u16(Integer.parseInt(target)); }

        String def = map.get(target);
        String[] args = def.split(" ");
        int result = -1;
        switch (args.length) {
            case 1:
                result = findValue(map, def);
                break;
            case 2:
                result = parse("NOT " + findValue(map, args[1]));
                break;
            case 3:
                result = parse(findValue(map, args[0]) + " " + args[1] + " " + findValue(map, args[2]));
                break;
        }
        map.put(target, ""+result);
        return result;
    }

    static Integer parse(String def) {
        String[] args = def.split(" ");
        switch (args.length) {
            // NOT
            case 2: return u16(~Integer.parseInt(args[1]));
            case 3: switch (args[1]) {
                case "AND": return u16(Integer.parseInt(args[0]) & Integer.parseInt(args[2]));
                case "OR": return u16(Integer.parseInt(args[0]) | Integer.parseInt(args[2]));
                case "LSHIFT": return u16(Integer.parseInt(args[0]) << Integer.parseInt(args[2]));
                case "RSHIFT": return u16(Integer.parseInt(args[0]) >> Integer.parseInt(args[2]));
            }
        }
        return -1;
    }

    static Integer u16(int i) {
        return Short.toUnsignedInt((short) i);
    }
}