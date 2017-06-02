package project01.csc214.duogames;

import android.widget.ImageView;

public class ConnectFourGame {

    private static final int COLUMN = 7;
    private static final int ROW = 6;
    private int[][] board;

    public ConnectFourGame() {
        board = new int[COLUMN][ROW];

    }


    public void setPiece(int column, int row, int player) {
        board[column][row] = player;
    }

    public int checkResult() {

        boolean player1, player2;

        // Check if Player One won
        player1 = checkBoardResult(1);

        // Check if Player Two won
        player2 = checkBoardResult(2);

        if(player1) return 1;
        else if(player2) return 2;
        else return 0;
    }

    public boolean checkBoardResult(int player) {
        int count = 0;

        // Check Horizontal
        for (int row = 0; row < 6; row++) {
            for(int col = 0; col < 7; col++) {

                // Check Column-by-Column
                if(board[col][row] == player) {
                    count++;
                } else {
                    count = 0;
                }

                // if count = 4;
                if(count == 4) {
                    return true;
                } else if (col == 6) {
                    count = 0;
                }

            }
        }

        // Check Vertical
        for (int col = 0; col < 7; col++) {

            count = 0; // Row-by-Row
            for(int row = 0; row < 6; row++) {
                // Check for 4 in a row
                if(board[col][row] == player) {
                    count++;
                } else {
                    count = 0;
                }

                // if count = 4;
                if(count == 4) {
                    return true;
                }

            }
        }

        // Check Diagonal Left -> Right
        for (int col = 0; col <= 3; col++) {

            count = 0; // Diagnal from Col and Row -> diag 4 positions
            for(int row = 0; row < 3; row++) {

                for(int i = 0; i < 4; i++) {

                    // Check for 4 in a row
                    if(board[col + i][row + i] == player) {
                        count++;
                    } else {
                        count = 0;
                    }

                    // if count = 4;
                    if(count == 4) {
                        return true;
                    }

                }

            }
        }

        // Check Diagonal Right -> Left
        for (int col = 6; col >= 3; col--) {

            count = 0; // Diagnal from Col and Row -> diag 4 positions
            for(int row = 0; row < 3; row++) {

                for(int i = 0; i < 4; i++) {

                    // Check for 4 in a row
                    if(board[col - i][row + i] == player) {
                        count++;
                    } else {
                        count = 0;
                    }

                    // if count = 4;
                    if(count == 4) {
                        return true;
                    }

                }

            }
        }

        return false;
    }


}
