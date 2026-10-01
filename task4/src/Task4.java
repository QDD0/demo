import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    private static int[] readFile(String path) {
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
        }

        return array;
    }

    private static void logic(String[] args) {
        int[] array = readFile(args[0]);
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
        System.out.println((counter >= 20 ? "20 ходов недостаточно для приведения всех элементов массива к одному числу" : counter));
    }

    public static void main(String[] args) {
        logic(args);
    }
}