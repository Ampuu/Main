/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{
    private int currentPlayer;
    private int [][] gameBoard;
    private boolean drawGame;

    public GameBoard() {
    newGame();
    }

public void newGame() {
    currentPlayer = 0;
    drawGame=false;
    gameBoard = new int [3][3];
    
    for (int c = 0; c < gameBoard.length; c++) {
        for (int r = 0; r < gameBoard.length; r++) {
           gameBoard[c][r]= -1;
        }
            
    }
        
}

/**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
        return currentPlayer;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {   if(!isGameOver() && gameBoard[col][row] == -1) {
        gameBoard[col][row] = currentPlayer;
 
        if(currentPlayer == 0) {
            currentPlayer=1;
        }
        else if (currentPlayer == 1) {
            currentPlayer = 0;
        }
        //TODO Implement this method
        return true;
    }
    return false;
    }
    public boolean isGameOver()
    { 
        for (int i = 0; i < gameBoard.length; i++) {
            if (
                    (gameBoard[0][i] != -1 && gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i]) 
                    || (gameBoard[i][0] != -1 && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]
                    
                    )) {return true;}
            
        }
        if (gameBoard[0][0] != -1 && gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]) {
            return true; }
        if (gameBoard[0][2] != -1 && gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]) {
            return true; }
        
        boolean full = true;
        for (int c = 0; c < gameBoard.length; c++) {
            for (int r = 0; r < gameBoard.length; r++) {
                if(gameBoard[c][r]==-1) {
                    full = false;
                }
                
            }
            
        }
        
        if(full) {
            drawGame = true;
            return true;
        }
        return false;
    }
        
        //TODO Implement this method
     


    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        if(drawGame){
            return -1;
        }
        if (currentPlayer == 0) {
            return 1;
        }
        else if (currentPlayer ==1) {
            return 0;
        }
        
        //TODO Implement this method
        return -3;
    }

    /**
     * Resets the game to a new game state.
     */

}
