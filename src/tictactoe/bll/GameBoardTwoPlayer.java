package tictactoe.bll;

import tictactoe.gui.controller.TicTacViewController;

/**
 * The GameBoardTwoPlayer class is the mandatory implementation for the TicTacToe assignment.
 * It is used for games where there are two human players.
 */
public class GameBoardTwoPlayer implements IGameModel {

    int player = 1;
    int STARTING_VALUE = -1;
    int gameBoard[][]  = new int[3][3] ;

    protected GameBoardTwoPlayer()
    {
        gameBoardArray();
    }

    /**
     * This is the array of our gameboard (gridpane)
     */
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
        if(player == 0)
            player = 1;
        else if(player == 1)
            player = 0;
        return player;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
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
        if(gameBoard[col][row] == STARTING_VALUE)
        {
            gameBoard[col][row] = player;

        }

            return true;

    }

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will return false.
     */
    @Override
    public boolean isGameOver() {
        //TODO CLEAR THE ARRAY!!!!! 12/10
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    @Override
    public int getWinner() {
        //TODO Implement this method
        return -1;
    }

    /**
     * Resets the game to a new game state.
     */
    @Override
    public void newGame() {
        //TODO Implement this method
    }

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