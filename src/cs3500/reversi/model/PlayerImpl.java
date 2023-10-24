package cs3500.reversi.model;

import java.util.Collections;

public class PlayerImpl implements Player{

  private boolean turn;

  private String playerName;

  public enum Color {
    BLACK,WHITE
  }

  private boolean isValidMove(int row, int column){
    //go through the board model and check if  either the move is valid or invalid


    return false;
  }

  @Override
  public void placePiece(int row, int column) throws IllegalStateException {


  }
}
