package Project1;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Arrays;

public class lotto2 {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(new File("C:/tmp/lottoIn.txt"));
             PrintStream ps = new PrintStream("C:/tmp/lottoOut.txt", StandardCharsets.UTF_8)) {

            int window;
            int pivot = 0;
            int lottoSize = 6;
            int num;
            int[] inputNumbers = new int[49];
            int[] results = new int[lottoSize];

            while ((num = in.nextInt()) != -1 && pivot <= 48) {
                for (int i = 0; i < inputNumbers.length; i++) {
                    inputNumbers[i] = num;
                    pivot++;
                }
                //inputNumbers[pivot++] = num;
                //pivot++;
            }

            int[] numbers = Arrays.copyOfRange(inputNumbers, 0, pivot);
            Arrays.sort(numbers);

            window = pivot - lottoSize;
            for (int i = 0; i <= window; i++) {
                for (int j = i + 1; j <= window + 1; j++) {
                    for (int k = j + 1; k <= window + 2; k++) {
                        for (int l = k + 1; l <= window + 3; l++) {
                            for (int m = l + 1; m <= window + 4; m++) {
                                for (int n = m + 1; n <= window + 5; n++) {
                                    results[0] = numbers[i];
                                    results[1] = numbers[j];
                                    results[2] = numbers[k];
                                    results[3] = numbers[l];
                                    results[4] = numbers[m];
                                    results[5] = numbers[n];



                                    if (isEven(results, 4) && isOdd(results, 4) && sameTen(results, 3)
                                            && sameEnding(results, 3) && consecutive(results)) {
                                        ps.printf("%d %d %d %d %d %d\n",
                                                results[0], results[1], results[2], results[3], results[4], results[5]);
                                        System.out.printf("%d %d %d %d %d %d\n",
                                                results[0], results[1], results[2], results[3], results[4], results[5]);

                                   }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();

        }

    }


    public static boolean isEven(int[] arr, int threshold) {
        int even=0;

        for (int el : arr) {
            if (el % 2 == 0) even++;
        }

        return even <= threshold;
    }

    public static boolean isOdd (int[] arr, int threshold) {
        int odds = 0;

        for (int num : arr) {
            if (num % 2 != 0) odds++;
       }
     return odds <= threshold;
    }

    public static boolean consecutive(int[] arr) {
        int consecutive = 0;

        for(int i = 0; i < 2; i++){
            if (arr[i] == arr[i + 1] - 1){
                consecutive++;
            }
        }
        return consecutive <= 2;
    }

    public static boolean sameEnding(int[] arr, int threshold) {
        int[] endings = new int[10];

        for (int num : arr) {
            endings[num % 10]++;
        }

        return Arrays.stream(endings).anyMatch(e -> e <= threshold);
    }

    public static boolean sameTen(int[] arr, int threshold) {
        int[] ten = new int[5];

        for (int num : arr) {
            ten[num/10]++;
        }

        return Arrays.stream(ten).anyMatch(t -> t <= threshold);
    }

}
