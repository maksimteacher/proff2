package AndreyKukuruza.Homework1.Task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int COUNT = 10000;
        long scoreALWithC, scoreAL, scoreLL, time1, time2;

        Random random = new Random();
        ArrayList<Integer> integerArrayList;
        LinkedList<Integer> integerLinkedList;


        //� �������
        System.out.println("������� � �������");
        integerArrayList = new ArrayList<>();
        integerLinkedList = new LinkedList<>();

        time1 = System.nanoTime();
        for (int i = 0; i < COUNT; i++) integerArrayList.add(0, random.nextInt(10000));
        time2 = System.nanoTime();
        scoreAL = time2 - time1;
        System.out.println("��� ArrayList ��� capacity: " + scoreAL);

        integerArrayList = new ArrayList<>(10000);
        time1 = System.nanoTime();
        for (int i = 0; i < COUNT; i++) integerArrayList.add(0, random.nextInt(10000));
        time2 = System.nanoTime();
        scoreALWithC = time2 - time1;
        System.out.println("��� ArrayList � capacity: " + scoreALWithC);

        time1 = System.nanoTime();
        for (int i = 0; i < COUNT; i++) integerLinkedList.addFirst(random.nextInt(10000));
        time2 = System.nanoTime();
        scoreLL = time2 - time1;
        System.out.println("��� LinkedList: " + (scoreLL));
        System.out.println();
        printResults(scoreAL, scoreLL, false);
        printResults(scoreALWithC, scoreLL, true);

        System.out.println("\n\n");


        //� ��������
        System.out.println("������� � ��������");
        integerArrayList = new ArrayList<>();
        integerLinkedList = new LinkedList<>();

        time1 = System.nanoTime();
        for (int i = 0; i < COUNT; i++) integerArrayList.add(integerArrayList.size() / 2, random.nextInt(10000));
        time2 = System.nanoTime();
        scoreAL = time2 - time1;
        System.out.println("��� ArrayList ��� capacity: " + scoreAL);

        integerArrayList = new ArrayList<>(10000);
        time1 = System.nanoTime();
        for (int i = 0; i < COUNT; i++) integerArrayList.add(integerArrayList.size() / 2, random.nextInt(10000));
        time2 = System.nanoTime();
        scoreALWithC = time2 - time1;
        System.out.println("��� ArrayList � capacity: " + scoreALWithC);

        time1 = System.nanoTime();
        for (int i = 0; i < COUNT; i++) integerLinkedList.add(integerLinkedList.size() / 2, random.nextInt(10000));
        time2 = System.nanoTime();
        scoreLL = time2 - time1;
        System.out.println("��� LinkedList: " + (scoreLL));
        System.out.println();
        printResults(scoreAL, scoreLL, false);
        printResults(scoreALWithC, scoreLL, true);

        System.out.println("\n\n");


        //� ������
        System.out.println("������� � �����");
        integerArrayList = new ArrayList<>();
        integerLinkedList = new LinkedList<>();

        time1 = System.nanoTime();
        for (int i = 0; i < COUNT; i++) integerArrayList.add(random.nextInt(10000));
        time2 = System.nanoTime();
        scoreAL = time2 - time1;
        System.out.println("��� ArrayList ��� capacity: " + scoreAL);

        integerArrayList = new ArrayList<>(10000);
        time1 = System.nanoTime();
        for (int i = 0; i < COUNT; i++) integerArrayList.add(random.nextInt(10000));
        time2 = System.nanoTime();
        scoreALWithC = time2 - time1;
        System.out.println("��� ArrayList � capacity: " + scoreALWithC);

        time1 = System.nanoTime();
        for (int i = 0; i < COUNT; i++) integerLinkedList.addLast(random.nextInt(10000));
        time2 = System.nanoTime();
        scoreLL = time2 - time1;
        System.out.println("��� LinkedList: " + (scoreLL));
        System.out.println();
        printResults(scoreAL, scoreLL, false);
        printResults(scoreALWithC, scoreLL, true);

        System.out.println("\n\n");

        long sum = 0;
        System.out.println("���������� ����");
        time1 = System.nanoTime();
        for (int i = 0; i < COUNT; i++) sum += integerArrayList.get(i);
        time2 = System.nanoTime();
        scoreAL = time2 - time1;
        System.out.println("��� ���������� ���� � ArrayList:  " + scoreAL);

        sum = 0;
        time1 = System.nanoTime();
        for (int i = 0; i < COUNT; i++) sum += integerLinkedList.get(i);
        time2 = System.nanoTime();
        scoreALWithC = time2 - time1;
        System.out.println("��� ���������� ���� � LinkedList: " + scoreALWithC);

        sum = 0;
        ListIterator<Integer> listIterator = integerLinkedList.listIterator();
        time1 = System.nanoTime();
        for (int i = 0; i < COUNT; i++) sum += listIterator.next();
        time2 = System.nanoTime();
        scoreLL = time2 - time1;
        System.out.println("��� ���������� ���� � LinkedList ����� ��������: " + scoreLL);
        System.out.println();
        printResultsSum(scoreAL, scoreALWithC);
        System.out.println("� ����������");
        printResultsSum(scoreAL, scoreLL);
        System.out.println("̳� LList`���");
        System.out.println("LinkedList � ����/LinkedList = " + (scoreALWithC * 1.0 / scoreLL));
    }

    private static void printResults(long scoreAL, long scoreLL, boolean capacity) {
        System.out.println((capacity ? "� capacity\n" : "��� capacity\n") + ((scoreAL * 1.0 / scoreLL < 1) ? (
                "ArrayList/LinkedList = " + (scoreLL * 1.0 / scoreAL)) :
                "LinkedList/ArrayList = " + (scoreAL * 1.0 / scoreLL))
        );
    }

    private static void printResultsSum(long scoreAL, long scoreLL) {
        System.out.println(scoreAL * 1.0 / scoreLL < 1 ? (
                "ArrayList/LinkedList = " + ((scoreLL * 1.0) / scoreAL)) :
                ("LinkedList/ArrayList = " + ((scoreAL * 1.0) / scoreLL)));
    }
}
