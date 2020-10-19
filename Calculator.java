import java.util.stream.*;

public class Calculator {

    public static int[] sorted(int[] arr) {

        int temp;

        for (int i = 0; (i < arr.length - 1); i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }

        return arr;
    }

    public static double median(int[] arr) {
        int mid, sumOfMiddleElements;
        double median;

        if (arr.length % 2 == 0) {
            mid = arr.length / 2;
            sumOfMiddleElements = arr[mid] + arr[mid - 1];

            median = ((double) sumOfMiddleElements / 2);
        } else {
            median = (double) arr[arr.length / 2];
        }

        return median;
    }

    public static double mean(int[] arr) {
        int divisor = arr.length;
        int sum = IntStream.of(arr).sum();

        double mean = sum / divisor;

        return mean;
    }

    public static int range(int[] arr) {
        int largest = arr[arr.length - 1];
        int smallest = arr[0];

        return largest - smallest;
    }

    public static int mode(int[] arr) {
        int maxValue = 0;
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i])
                    count++;

            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = arr[i];
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 3, 12, 7, 2, 11, 9, 2, 44, 10, 3, 2, 3, 12, 7, 2, 11, 9, 2 };

        arr = sorted(arr);

        System.out.println("Mean: " + mean(arr));
        System.out.println("Median: " + median(arr));
        System.out.println("Mode: " + mode(arr));
        System.out.println("Range: " + range(arr));

    }
}