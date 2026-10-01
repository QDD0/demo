import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void moveArray(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int n2 = Integer.parseInt(args[2]);
        int m2 = Integer.parseInt(args[3]);

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

        for (int i : list) {
            System.out.print(i);
        }
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
        moveArray(args);
    }
}