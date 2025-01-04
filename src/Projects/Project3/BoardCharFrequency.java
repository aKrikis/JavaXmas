package Project3;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Board 128x2
 */
public class BoardCharFrequency {

    public static void main(String[] args) {

        int[][] arr = new int[128][2]; // Έκανα τον πινακα int για να έχω τους λατινικούς χαρακτήρες σε ASCII

        // αρχικοποίηση πίνακα και γέμισμα με χαρακτήρες
        for (int i = 0; i < 128; i++) {
            if((i > 'A' && i <= 'Z') || (i > 'a' && i <= 'z')){
                arr[i][0] = i;
                arr[i][1] = 0;
            }
        }

        try (Scanner sc = new Scanner(new File("input.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                for (char c : line.toCharArray()){   // μετατροπή σε char
                    if((c > 'A' && c <= 'Z') || (c > 'a' && c <= 'z')){
                        c = Character.toLowerCase(c);
                        arr[c][1]++;
                    }
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]) );
        System.out.println("Ταξινόμηση ανά Χαρακτήρα");
        printArray(arr);

        Arrays.sort(arr, (a,b) -> b[1] - a[1] );
        System.out.println("Ταξινόμηση κατά συχνότητα εμφάνισης");
        printArray(arr);

    }

    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for(int col : row) {
                if (col > 0){
                    System.out.println(Arrays.toString(row) + " : " + col);
                }
            }
        }
    }
}
