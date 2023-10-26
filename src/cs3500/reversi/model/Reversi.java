package cs3500.reversi.model;

import java.util.HashMap;
import java.util.List;

public interface Reversi {
  /**
   * Method to start the game.
   */
  void startGame();

  /**
   * Checks if the game is over.
   * @return boolean if game is over
   */
  boolean isGameOver();

  /**
   * Method to get score of the game.
   * @return integer of score
   */
  Tuple<Integer,Integer> getScore();

  /**
   * Takes in the proper player and places the move there
   * @param row in the board
   * @param column in the board
   */
  void placeTile(int row,int column);

  /**
   * Passes the move
   */
  void passMove();

  /**
   * Gets the current turn
   * @return the color of the player whose turn it is
   */
  BasicReversi.Color getTurn();

  /**
   * Gets the Array of Array representation of the board.
   * @return a board.
   */
  List<List<IDisc>> getBoard();

  Integer getLength();




}
