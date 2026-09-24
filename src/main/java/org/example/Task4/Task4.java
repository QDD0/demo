package org.example.Task4;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    private static int[] readFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("путь: ");
        String path = scanner.nextLine();
        File file = new File(path);
        List<Integer> list = new ArrayList<>();

        try {
            Scanner read = new Scanner(file);

            while (read.hasNextInt()) {
                list.add(read.nextInt());
            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
            System.out.print(array[i] + " ");
        }

        return array;
    }

    private static void logic() {
        int[] array = readFile();
        int counter = 0;
        int sum = 0;
        for (int i : array) {
            sum += i;
        }

        int average = sum / array.length;
        int index = 0;
        while (counter < 20) {
            if (index == array.length) {
                index = 0;
            }

            if (array[index] == average) {
                index++;
                continue;
            } else if (array[index] > average) {
                array[index]--;
            } else {
                array[index]++;
            }

            counter++;

            boolean check = true;
            for (int i : array) {
                if (i != average) {
                    check = false;
                    break;
                }
            }

            if (check) {
                break;
            }
        }
        System.out.println(("\nшагов " + (counter >= 20 ? "> 20" : counter)));
    }

    public static void main(String[] args) {
        logic();
    }
}
