package Project5;

public class Theatre {

    public boolean[][] seats = new boolean[30][12];

    public Theatre() {
        for (int i=0; i<30; i++) {
            for (int j =0; j<12; j++) {
                seats[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {

        Theatre theatre = new Theatre();

        theatre.book('B', 5);
        theatre.book('A', 7);
        theatre.book('M', 7); // Είσοδος λάθος θέσης

        theatre.cancel('B', 5); // Ακύρωση θέσης που έχει γίνει κράτηση
        theatre.cancel('D', 15); // Ακύρωση θέσης που ΔΕΝ έχει γίνει κράτηση

    }

    public void book(char column, int row){
        int colIn = column - 'A';
        int rowIn = row -1;

        if (rowIn < 0 || rowIn > 29 || colIn < 0 || colIn > 11){
            System.out.println("Δώσατε λάθος θέση");
        }

        if (rowIn > 0 && rowIn <= 30 && colIn >= 0 && colIn < 12) {
            if(!seats[rowIn][colIn]) {
                seats[rowIn][colIn] = true;
                System.out.println("Επιτυχής κράτηση θέσης: "+ column + row);
            }else {
                System.out.println("Η θέση είναι πιασμένη");
            }
        }
    }

    public void cancel(char column, int row){
        int colIn = column - 'A';
        int rowIn = row -1;

        if (rowIn < 0 || rowIn > 29 || colIn < 0 || colIn > 11){
            System.out.println("Δώσατε λάθος θέση");
        }

        if (rowIn > 0 && rowIn <= 30 && colIn >= 0 && colIn < 12) {
            if(seats[rowIn][colIn]) {
                seats[rowIn][colIn] = false;
                System.out.println("Ακύρωση κράτησης θέσης: "+ column + row);
            }else {
                System.out.println("Δεν έχει γίνει κράτηση της θέσης");
            }
        }
    }
}
