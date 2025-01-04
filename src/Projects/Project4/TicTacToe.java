package Project4;

import java.util.Scanner;
/**
 * Tictactoe classic game
 */
public class TicTacToe {

    public static void main(String[] args) {

        char [] [] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        char currentPlayer = 'X';
        printGameBoard(gameBoard);
        int position;
        boolean game = false;
        Scanner in = new Scanner (System.in);

            while(!game) {
                System.out.println("Player " + currentPlayer + " is your turn.");
                System.out.println("Select the position you want to play (1-9). Choose wisely..");
                position = in.nextInt();

                if (isSpotAvailable(gameBoard, position)){
                    playerMove(gameBoard, currentPlayer, position);
                    printGameBoard(gameBoard);
                    if (checkWin(gameBoard, currentPlayer)) {
                        System.out.println("Player " + currentPlayer + " wins!!");
                        System.out.println("Congratulation!!");
                        game = true;
                    } else if(isBoardIsFull(gameBoard)) {
                        System.out.println("The game is a draw..");
                        game= true;
                    }

                    currentPlayer = switchPlayer(currentPlayer);

                }else {
                    System.out.println("Spot is taken..");
                    printGameBoard(gameBoard);
                    continue;
                }
            }
    }



    public static boolean isBoardIsFull(char[][] gameBoard){

        for (int i = 0; i<gameBoard.length -1; i++){
            for (int j=0; j<gameBoard[i].length; j++){
                if (gameBoard[i][j] == ' ' ) return false;
            }
        } return true;
    }

    public static boolean checkWin(char[][] gameBoard, char currentPlayer) {

        // Δάσκαλε αν είχα φτιάξει αλλιώς τον πίνακα θα τα έβαζα μέσα σε for
        // row win conditions
        if (gameBoard[0][0] == currentPlayer && gameBoard[0][2] == currentPlayer && gameBoard[0][4] == currentPlayer) return true;
        if (gameBoard[2][0] == currentPlayer && gameBoard[2][2] == currentPlayer && gameBoard[2][4] == currentPlayer) return true;
        if (gameBoard[4][0] == currentPlayer && gameBoard[4][2] == currentPlayer && gameBoard[4][4] == currentPlayer) return true;

        // col win conditions
        if (gameBoard[0][0] == currentPlayer && gameBoard[2][0] == currentPlayer && gameBoard[4][0] == currentPlayer) return true;
        if (gameBoard[0][2] == currentPlayer && gameBoard[2][2] == currentPlayer && gameBoard[4][2] == currentPlayer) return true;
        if (gameBoard[0][4] == currentPlayer && gameBoard[2][4] == currentPlayer && gameBoard[4][4] == currentPlayer) return true;

        // diagonal win conditions
        if (gameBoard[0][0] == currentPlayer && gameBoard[2][2] == currentPlayer && gameBoard[4][4] == currentPlayer) return true;
        if (gameBoard[0][4] == currentPlayer && gameBoard[2][2] == currentPlayer && gameBoard[4][0] == currentPlayer) return true;
        return false;
    }

    public static boolean isSpotAvailable(char[][] gameBoard, int position){

        if ((position < 1) || (position > 9)){
            System.out.println("Invalid choice. We said to choose wisely player.. ");
            return false;
        }

        switch (position) {
            case 1:
                if (gameBoard[0][0] == ' ') return true;
                break;
            case 2:
                if (gameBoard[0][2] == ' ') return true;
                break;
            case 3:
                if (gameBoard[0][4] == ' ') return true;
                break;
            case 4:
                if (gameBoard[2][0] == ' ') return true;
                break;
            case 5:
                if (gameBoard[2][2] == ' ') return true;
                break;
            case 6:
                if (gameBoard[2][4] == ' ') return true;
                break;
            case 7:
                if (gameBoard[4][0] == ' ') return true;
                break;
            case 8:
                if (gameBoard[4][2] == ' ') return true;
                break;
            case 9:
                if (gameBoard[4][4] == ' ') return true;
                break;
            default:
                break;
        }
        return false;
    }

    public static void playerMove(char[][] gameBoard , char currentPlayer, int position) {

            switch (position) {
                case 1:
                    gameBoard[0][0] = currentPlayer;
                    break;
                case 2:
                    gameBoard[0][2] = currentPlayer;
                    break;
                case 3:
                    gameBoard[0][4] = currentPlayer;
                    break;
                case 4:
                    gameBoard[2][0] = currentPlayer;
                    break;
                case 5:
                    gameBoard[2][2] = currentPlayer;
                    break;
                case 6:
                    gameBoard[2][4] = currentPlayer;
                    break;
                case 7:
                    gameBoard[4][0] = currentPlayer;
                    break;
                case 8:
                    gameBoard[4][2] = currentPlayer;
                    break;
                case 9:
                    gameBoard[4][4] = currentPlayer;
                    break;
                default:
                    break;
            }
    }

    public static void printGameBoard(char[][] gameBoard){
        for (char[] row: gameBoard) {
            for(char c: row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static char switchPlayer(char currentPlayer) {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        return currentPlayer;
    }
}