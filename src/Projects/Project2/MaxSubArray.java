package Project2;

/**
 * Ξεκινάμε με 2 μεταβλητές localMax και arrayMax
 * localMax = το μέγιστο άθροισμα μέχρι το στοιχείο που θα βρίσκομαι (τρέχον στοιχείο)
 * arrayMax = το μέγιστο άθροισμα που θα έχουμε δει μέχρι τώρα
 * Για κάθε στοιχείο του πίνακα θα ενημερώνεται το localMax και αν είναι μεγαλύτερο απο το arrayMax θα το
 * ενημερώνομαι, όπου και θα έχει τη μεγαλύτερη τιμή στο τέλος
 */
public class MaxSubArray {

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int localMax = arr[0];
        int arrayMax= arr[0];

        for (int i = 0; i < arr.length; i++){
            localMax = Math.max(arr[i], localMax + arr[i]);
            arrayMax = Math.max(arrayMax, localMax);

        }

        System.out.println("Maximum sum subarray: " + arrayMax);
    }
}

/**
 * Διατρέχουμε τον πίνακα μόνο μία φορά με χρήση μιας for όπου κάθε επανάληψη εκτελεί απλές συγκρίσεις και αναθέσεις.
 * Συνεπώς, η συνολική πολυπλοκότητα είναι O(n).
 */