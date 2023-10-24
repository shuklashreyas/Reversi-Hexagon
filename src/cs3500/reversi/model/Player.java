package cs3500.reversi.model;

public interface Player {


  /**
   * This method places a piece in the board. If the move is not valid, the method throws
   * an Illegal state exception.
   */
    void placePiece(int row, int column) throws  IllegalStateException;

    void passMove();
}
