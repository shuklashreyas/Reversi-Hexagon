package cs3500.reversi.model;

import java.util.ArrayList;
import java.util.List;

public class BasicReversi implements  Reversi{

  public enum Color{
    BLACK,WHITE
  }

  private Color turn;

  private int numSides;

  private boolean isGameStarted;

  private List<List<IDisc>> board=new ArrayList<>();

  private void constructBoard(){
    //add arrays to the board of the corresponding size in loops
    for(int i=1; i<=numSides; i++){
      List<IDisc> newRow=new ArrayList<>(i);
      board.add(newRow);
      if(i==numSides){
        for(int j=i; j>0; j--){
          List<IDisc> row=new ArrayList<>(j);
          board.add(row);
        }
      }
    }
  }


  private void setTurn(){
    //helper method to set the current turn to the nect whenever a move ius made
  }



  public BasicReversi(int numSides){
    this.numSides=numSides;
    this.turn=Color.BLACK;
  }




  @Override
  public void startGame() {
  //starts the game
  }

  @Override
  public boolean isGameOver() {

    //checks if the game is voer
    return false;
  }

  @Override
  public Integer getScore() {
    //gets the score of the game
    return null;
  }

  @Override
  public void placeTile(int row, int column) {

  }

  @Override
  public void passMove() {

  }

  @Override
  public Color getTurn(){

    return null;
  }

  @Override
  public List<List<IDisc>> getBoard(){
    return this.board;
  }
}
