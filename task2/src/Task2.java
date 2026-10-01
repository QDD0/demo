import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    private static final double EPSILON = 1e-9;

    public static void readFiles(String file1, String file2) throws FileNotFoundException {
        List<double[]> lines = new ArrayList<>();
        List<Double> list = new ArrayList<>();

        try (Scanner readFile = new Scanner(new File(file1));
             Scanner readSecondFile = new Scanner(new File(file2))) {

            while (readFile.hasNextLine()) {
                String testLine = readFile.nextLine().trim();
                if (testLine.isEmpty()) continue;

                String[] values = testLine.split("\\s+");
                double[] nums = new double[values.length];
                for (int i = 0; i < values.length; i++) {
                    nums[i] = Double.parseDouble(values[i]);
                }
                lines.add(nums);
            }

            while (readSecondFile.hasNextDouble()) {
                list.add(readSecondFile.nextDouble());
            }
        }

        double[] mid = lines.get(0);
        double[] radius = lines.get(1);

        double xc = mid[0];
        double yc = mid[1];
        double a = radius[0];
        double b = radius[1];

        for (int k = 0; k + 1 < list.size(); k += 2) {
            double x0 = list.get(k);
            double y0 = list.get(k + 1);

            double dx = x0 - xc;
            double dy = y0 - yc;

            double result = (dx * dx) / (a * a) + (dy * dy) / (b * b);

            if (Math.abs(result - 1.0) < EPSILON) {
                System.out.println(result + " на эллипсе");
            } else if (result < 1.0) {
                System.out.println(result + " внутри");
            } else {
                System.out.println(result + " снаружи");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFiles(args[0], args[1]);
    }
}