package org.example.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void moveArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        System.out.print("m = ");
        int m = scanner.nextInt();

        System.out.println();
        System.out.print("n2 = ");
        int n2 = scanner.nextInt();
        System.out.print("m2 = ");
        int m2 = scanner.nextInt();

        int[] arr = new int[n];
        int[] secondArray = new int[n2];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = i + 1;
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(path(arr, m));
        list.addAll(path(secondArray, m2));

        System.out.println(list);
    }

    private static List<Integer> path(int[] arr, int m) {
        List<Integer> list = new ArrayList<>();
        int index = 0;

        do {
            list.add(arr[index]);
            index = (index + m - 1) % arr.length;
        } while (index != 0);

        return list;
    }

    public static void main(String[] args) {
        moveArray();
    }
}
