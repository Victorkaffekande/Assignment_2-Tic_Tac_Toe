package tictactoe.bll;

import java.util.Random;

/**
 * The GameBoardSinglePlayer class is the optional and advanced implementation for the TicTacToe assignment.
 * It is used for games where there are one human player vs. a computer player.
 */
public class GameBoardSinglePlayer implements IGameModel {

    int startingPlayer = 1;
    int player;
    int playerWin = 2;
    int aiWin = 3;
    int STARTING_VALUE = -1;
    int gameBoard[][]  = new int[3][3] ;
    static Random randomR = new Random();
    static Random randomC = new Random();
    int winner = -1;

    protected GameBoardSinglePlayer()
    {
        newGame();
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
        if(player == 0)
            player = 1;
        else if(player == 1)
            player = 0;
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
//TODO lav en AI, der kan se hvilke felter den må sætte et tegn på og så sæt det på et random sted.
        if(isGameOver())
        {
            return false;
        }

        if(gameBoard[col][row] == STARTING_VALUE)
        {
            gameBoard[col][row] = player;
            if (isGameOver()){
                return true;
            }else{
                AiPlay();
                return true;
            }
        }
        return false;
    }

    public void AiPlay(){
        getNextPlayer();
        int guessC;
        int guessR;
        do{
            guessC = guessCol();
            guessR = guessRow();
        }while (gameBoard[guessC][guessR] != STARTING_VALUE);
        gameBoard[guessC][guessR] = player;
    }

    public static int guessRow(){
        return randomR.nextInt(3);

    }
    public static int guessCol(){
        return randomC.nextInt(3);
    }
    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will return false.
     */
    @Override
    public boolean isGameOver() {

        //Does player 0 or 1 win, or is it a draw
        if (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin()){

            if (player == 0){
                winner = playerWin;

            }
            else
            if(player == 1){
                winner = aiWin;
            }
            return true;
        }

        if (checkDraw()){
            winner = -1;
            return true;
        }

        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw or if the game is still running.
     *
     * @return int id of winner, or -1 if draw or if gameOver() == false.
     */
    @Override
    public int getWinner() {
        return winner;
    }

    public boolean checkDraw(){
        //check for empty fields with "for" loop
        int count=9;
        for (int i = 0; i< 3; i++){
            for (int n =0; n < 3; n++){
                if (gameBoard[i][n] != STARTING_VALUE) {
                    count--;
                }
            }
        }

        if (count == 0){
            return true;

        }
        return false;
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
    public void newGame() {
        player = startingPlayer;
        gameBoardArray();
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
