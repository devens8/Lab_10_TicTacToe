import java.util.Scanner;

/*
    Pseudocode:


 */

public class TicTacToeGame {
    //declare class variables
    private static final int ROW = 5;
    private static final int COL = 5;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args) {
        boolean currentMove = true;
        boolean end = false;
        boolean validInput;
        Scanner input =  new Scanner(System.in);//sets up the scanner class
        System.out.print("\nWelcome to the Tic Tac Toe Game! ");


        do {
            System.out.println("One Player will place X's and the other O's. To begin the game, place the first X by entering the row and column for the spot below \n");
            clearBoard();
            display();
            do {
                end = false;
                do {
                    int rowMove = SafeInput.getRangedInt(input, "Please enter the row of your move: ", 1, 3);
                    if (rowMove == 1) {
                        rowMove = 0;
                    } else if (rowMove == 3) {
                        rowMove = 4;
                    }

                    int colMove = SafeInput.getRangedInt(input, "Please enter the column of your move: ", 1, 3);
                    if (colMove == 1) {
                        colMove = 0;
                    } else if (colMove == 3) {
                        colMove = 4;
                    }

                    if (isValidMove(rowMove, colMove)) {
                        validInput = true;
                        if (currentMove) {
                            board[rowMove][colMove] = "X";
                        } else {
                            board[rowMove][colMove] = "O";
                        }
                    } else {
                        System.out.println("\nThat spot is taken on the board! Please try a different spot");
                        validInput = false;
                    }

                } while (!validInput);

                System.out.println("");
                display();

                if (isWin("X")) {
                    System.out.println("\nPlayer X has won!");
                    end = true;
                } else if (isWin("O")) {
                    System.out.println("\nPlayer O has won!");
                    end = true;
                } else if (isTie()) {
                    System.out.println("\nIt's a Tie! Good Game");
                    end = true;
                } else {
                    currentMove = !currentMove;
                    if (currentMove) {
                        System.out.println("\nNow it is X's turn! Please enter the row and column below");
                    } else {
                        System.out.println("\nNow it is O's turn! Please enter the row and column below");

                    }
                }
            } while (!end);

        }while(SafeInput.getYNConfirm(input,"Would you like to play again? Enter Y or N"));
    }

    // sets all the board elements to a space
    private static void clearBoard(){
        //sets the vertical bars of the board
        for (int i = 0; i < ROW; i+=2) {
            for (int j = 1; j < COL; j+=2) {
                board[i][j] = "|";
            }
        }

        //sets the horizontal bars of the board
        for (int i = 1; i < ROW; i+=2) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = "——";
            }
        }

        //sets the empty spaces
        for (int i = 0; i < ROW; i+=2) {
            for (int j = 0; j < COL; j+=2) {
                board[i][j] = " ";
            }
        }
    }

    // shows the Tic Tac Toe game used as part of the prompt for the users move choice
    private static void display(){
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%3s", board[i][j]);
            }
            System.out.println("");
        }
    }

    // returns true if there is a space at the given proposed move coordinates which means it is a legal move.
    private static boolean isValidMove(int row, int col){
        if(board[row][col] == " "){
            return true;
        }
        return false;
    }

    // checks to see if there is a win state on the current board for the specified player (X or O)
    private static boolean isWin(String player){
        if(isRowWin(player) || isColWin(player) || isDiagonalWin(player)){
            return true;
        }
        return false;
    }

    // checks for a col win for specified player
    private static boolean isColWin(String player){
        for(int i = 0; i < ROW; i+=2){
            int counter = 0;
            for(int j = 0; j < COL; j+=2){
                if(board[j][i] == player){
                    counter ++;
                }
            }
            if (counter == 3){
                return true;
            }
        }
        return false;
    }

    // checks for a row win for the specified player
    private static boolean isRowWin(String player){
        for(int i = 0; i < ROW; i+=2){
            int counter = 0;
            for(int j = 0; j < COL; j+=2){
                if(board[i][j] == player){
                    counter ++;
                }
            }
            if (counter == 3){
                return true;
            }
        }
        return false;
    }

    // checks for a diagonal win for the specified player
    private static boolean isDiagonalWin(String player){
        int column = 0;
        int counter = 0;
        for(int i = 0; i < ROW; i+=2){
            if (board[i][column] == player) {
                counter++;
            }
            column+=2;
        }
        if (counter == 3){
            return true;
        }

        column = 0;
        counter = 0;
        for(int i = ROW-1; i >= 0; i-=2){
            if (board[i][column] == player) {
                counter++;
            }
            column+=2;
        }
        if (counter == 3){
            return true;
        }
        return false;
    }


    // checks for a tie condition: all spaces on the board are filled OR there is an X and an O in every win vector
    private static boolean isTie() {
        int counter = 0;
        //checks each column
        for (int i = 0; i < ROW; i += 2) {
            for (int j = 0; j < COL; j += 2) {
                if (board[j][i] == "X") {
                    counter++;
                    break;
                }
            }
        }

        //checks each row
        for(int i = 0; i < ROW; i+=2){
            for(int j = 0; j < COL; j+=2){
                if(board[i][j] == "X"){
                    counter ++;
                    break;
                }
            }
        }

        int column1 = 0;
        for(int i = 0; i < ROW; i+=2){
            if (board[i][column1] == "X") {
                counter++;
                break;
            }
            column1+=2;
        }

        int column2 = 4;
        for(int i = ROW-1; i > 0; i-=2){
            if (board[i][column2] == "X") {
                counter++;
                break;
            }
            column2-=2;
        }

        //checks each column
        for (int i = 0; i < ROW; i += 2) {
            for (int j = 0; j < COL; j += 2) {
                if (board[j][i] == "O") {
                    counter++;
                    break;
                }
            }
        }

        //checks each row
        for(int i = 0; i < ROW; i+=2){
            for(int j = 0; j < COL; j+=2){
                if(board[i][j] == "O"){
                    counter ++;
                    break;
                }
            }
        }

        int column3 = 0;
        for(int i = 0; i < ROW; i+=2){
            if (board[i][column3] == "O") {
                counter++;
                break;
            }
            column3+=2;
        }

        int column4 = 0;
        for(int i = ROW-1; i >= 0; i-=2){
            if (board[i][column4] == "O") {
                counter++;
                break;
            }
            column4+=2;
        }

        if(counter == 16){
            return true;
        }

        return false;
    }
}