package tictactoe.bll;

import java.util.Random;

/**
 * The GameBoardSinglePlayer class is the optional and advanced implementation for the TicTacToe assignment.
 * It is used for games where there are one human player vs. a computer player.
 */
public class GameBoardSinglePlayer implements IGameModel {

    int player = 1;
    int STARTING_VALUE = -1;
    int gameBoard[][]  = new int[3][3] ;
    static Random randomR = new Random();
    static Random randomC = new Random();

    protected GameBoardSinglePlayer()
    {

    }
    public void gameBoardArray()
    {
        gameBoard[0][0] = STARTING_VALUE;
        gameBoard[0][1] = STARTING_VALUE;
        gameBoard[0][2] = STARTING_VALUE;
        gameBoard[1][0] = STARTING_VALUE;
        gameBoard[1][1] = STARTING_VALUE;
        gameBoard[1][2] = STARTING_VALUE;
        gameBoard[2][0] = STARTING_VALUE;
        gameBoard[2][1] = STARTING_VALUE;
        gameBoard[2][2] = STARTING_VALUE;


    }
    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    @Override
    public int getNextPlayer() {
        if(player == 1)
            player = 0;

        else if (player == 0)
            player = 1;
        return player;
    }

    /**
     * Attempts to let the current player play at the given coordinates. If the
     * attempt is successful the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver ==
     * true this method will always return false.
     */
    @Override
    public boolean play(int col, int row) {

        if(isGameOver())
        {
            return false;
        }

        if(gameBoard[col][row] == STARTING_VALUE)
        {
            gameBoard[col][row] = player;
            int guessRow;
            int guessCol;
            do {
                guessRow = guessRow();
                guessCol = guessCol();
            } while (gameBoard[guessCol][guessRow] != STARTING_VALUE);


            return true;

        }

        return false;
    }

    public static int guessRow(){
        return randomR.nextInt(2);

    }
    public static int guessCol(){
        return randomC.nextInt(2);
    }
    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will return false.
     */
    @Override
    public boolean isGameOver() {
        //TODO Implement this method
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw or if the game is still running.
     *
     * @return int id of winner, or -1 if draw or if gameOver() == false.
     */
    @Override
    public int getWinner() {
        //TODO Implement this method
        return 0;
    }
    /**
     checks if a row / col has the same value
     */
    private boolean checkRowCol(int c1, int c2, int c3) {
        return ((c1 != STARTING_VALUE) && (c1 == c2) && (c2 == c3));
    }


    /**
     * Checks the rows for a possible win.
     *
     * @return true if there is three matching symbols in a row
     */
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(gameBoard[i][0], gameBoard[i][1], gameBoard[i][2])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the columns for a possible win.
     *
     * @return true if there is three matching symbols in a column
     */
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(gameBoard[0][i], gameBoard[1][i], gameBoard[2][i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the diagonals for a possible win.
     *
     * @return true if there is three matching symbols in a diagonal
     */
    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2])) || (checkRowCol(gameBoard[0][2], gameBoard[1][1], gameBoard[2][0])));
    }

    /**
     * Resets the game to a new game state.
     */
    @Override
    public void newGame() {gameBoardArray();}



    /**
     * Returns the value representing which players has played the given field.
     *
     * @param col The column to look at.
     * @param row The row to look at.
     * @return Will return 0 if player 0 has played the field, 1 for player one, and -1 if no player has played the field.
     */
    @Override
    public int getPlayerAt(int col, int row) {
        if (gameBoard[col][row] == STARTING_VALUE)
        {
            return -1;
        }
        else if (gameBoard[col][row] == 0)
        {
            return 0;
        }
        else if (gameBoard[col][row] == 1)
        {
            return 1;
        }
        return -1;
    }

}
