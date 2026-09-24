package org.example.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void readFiles() throws FileNotFoundException {
        List<int[]> lines = new ArrayList<>();
        Scanner readFile = new Scanner(new File("src/main/java/org/example/task2/file1.txt"));
        Scanner readSecondFile = new Scanner(new File("src/main/java/org/example/task2/file2.txt"));
        List<Integer> list = new ArrayList<>();

        try {
            while (readFile.hasNextLine()) {
                String testLine = readFile.nextLine();

                String[] values = testLine.split("\\s+");
                int[] nums = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    nums[i] = Integer.parseInt(values[i]);
                }
                lines.add(nums);
            }

            while (readSecondFile.hasNextInt()) {
                list.add(readSecondFile.nextInt());
            }
            readFile.close();
            readSecondFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int[] mid = lines.get(0);
        int[] radius = lines.get(1);

        double xc = mid[0];
        double yc = mid[1];
        double a = radius[0];
        double b = radius[1];

        for (int k = 0; k < list.size(); k += 2) {
            double x0 = list.get(k);
            double y0 = list.get(k + 1);

            double dx = x0 - xc;
            double dy = y0 - yc;

            double result = (dx * dx) / (a * a) + (dy * dy) / (b * b);

            if (result < 1) {
                System.out.println(result + " внутри");
            } else if (result == 1) {
                System.out.println(result + " на эллипсе");
            } else {
                System.out.println(result + " снаружи");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFiles();
    }
}