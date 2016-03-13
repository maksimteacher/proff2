package AndreyKukuruza.Homework1.Task4;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MyHashSet<String> stringMyHashSet = new MyHashSet<>();
        System.out.println(stringMyHashSet.size());
        stringMyHashSet.add("");
        System.out.println(stringMyHashSet.size());
        stringMyHashSet.add("q");
        stringMyHashSet.add("e");
        stringMyHashSet.add("e");
        stringMyHashSet.add("e");
        stringMyHashSet.add("weqe");
        stringMyHashSet.add("qweqweq qdqwd");
        stringMyHashSet.add("qwpfqfkpqfk");
        System.out.println(stringMyHashSet.size());

        System.out.println(stringMyHashSet.contains(""));
        System.out.println(stringMyHashSet.contains("a"));
        System.out.println(stringMyHashSet.contains("q"));
        System.out.println(stringMyHashSet.contains("qs"));
        System.out.println(stringMyHashSet.contains("qwpfqfkpqfk"));
        System.out.println(stringMyHashSet.contains("qwpfqfkpqfk "));

        MyHashSet<Point> pointMyHashSet = new MyHashSet<>();
        Point point = new Point(12, 12);
        Point point2 = new Point(12, 12);
        System.out.println(pointMyHashSet.contains(point));
        pointMyHashSet.add(point);
        System.out.println(pointMyHashSet.contains(point));
        pointMyHashSet.add(point2);
        System.out.println(pointMyHashSet.size());
    }
}