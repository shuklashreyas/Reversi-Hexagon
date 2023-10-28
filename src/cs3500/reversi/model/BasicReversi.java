package cs3500.reversi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicReversi implements  Reversi{

  public enum Color{
    BLACK,WHITE,GRAY
  }

  private Color turn;

  private int length;

  private boolean isGameStarted;

  private List<List<IDisc>> board=new ArrayList<>();

  private void checkIsGameStarted(){
    if(!isGameStarted){
      throw new IllegalStateException("game is not started");
    }
  }

  private List<IDisc> fillBoard(Integer rowLength){
    List<IDisc> row=new ArrayList<>();
    for(int i=0; i<rowLength; i++){
      row.add(new IDisicImpl(Color.GRAY));
    }
    return row;

  }

  private void constructBoard(){
    //add arrays to the board of the corresponding size in loops
    for(int i=length; i<length*2; i++){
      List<IDisc> row=fillBoard(i);
      board.add(row);
      if(i==(length*2)-1){
        for(int j=i-1; j>=length; j--){
          List<IDisc> newRow=fillBoard(j);
          board.add(newRow);
        }
      }
    }
  }

  private void placeInitialPieces(){
    int numPieces=length;

    Color currColor=Color.BLACK;

    Tuple<Integer, Integer> center=new Tuple<>(length-1,length-1);
    Stack<Tuple<Integer,Integer>> directions=new Stack<>();
    directions.add(new Tuple<>(-1,-1));
    directions.add(new Tuple<>(-1,0));
    directions.add(new Tuple<>(0,1));
    directions.add(new Tuple<>(0,-1));
    directions.add(new Tuple<>(-1,-1));
    directions.add(new Tuple<>(1,0));
    directions.add(new Tuple<>(1,-1));

   // board.get(center.getFirst()).set(center.getSecond(),new IDisicImpl(currColor));
    while(numPieces>0){
      if(!directions.isEmpty()){
        Tuple<Integer,Integer> direction=directions.pop();
        int newRow=center.getFirst()+direction.getFirst();
        int newCol=center.getSecond()+direction.getSecond();
        if(newRow< board.size()){
          List<IDisc> row=board.get(newRow);
          if(newCol<row.size()){
            board.get(newRow).set(newCol,new IDisicImpl(currColor));
            numPieces--;
            if(currColor==Color.BLACK){
              currColor=Color.WHITE;
            }else{
              currColor=Color.BLACK;
            }
          }
        }
      }
    }
  }






  private void setTurn(){
    //helper method to set the current turn to the nect whenever a move ius made
    if(this.turn==Color.BLACK){
      this.turn=Color.WHITE;
    }
    if(this.turn==Color.WHITE){
      this.turn=Color.BLACK;
    }
  }



  public BasicReversi(int length){
    if(length<=0){
      throw new IllegalArgumentException("invlaid input");
    }

    this.length=length;
    this.turn=Color.BLACK;
  }




  @Override
  public void startGame() {
    if(this.isGameStarted){
      throw new IllegalStateException("game already started");
    }
    this.isGameStarted=true;
    //starts the game
    constructBoard();
    placeInitialPieces();

  }

  @Override
  public boolean isGameOver() {
    checkIsGameStarted();
    //checks if the game is over
    //game is over when either all the tiles are filled or there are no playable moves




    return false;
  }

  @Override
  public Tuple<Integer,Integer> getScore() {
    checkIsGameStarted();


    int whiteScore=0;
    int blackScore=0;
    //gets the score of the game
    for(int i=0; i<this.board.size(); i++){
      List<IDisc> row=this.board.get(i);
     // System.out.println(row);
      for(int j=0; j<row.size(); j++){
        IDisc disc=row.get(j);

        if(disc.getColor()==Color.WHITE){
          //add these values to the hash

          whiteScore++;

        }
        if(disc.getColor()==Color.BLACK){
          blackScore++;
        }
      }
    }

    return new Tuple<>(whiteScore,blackScore);
  }
  private void isValidMove(int row, int column){
    List<Tuple<Integer,Integer>> directions=new ArrayList<>();

  }
  @Override
  public void placeTile(int row, int column) {
    checkIsGameStarted();
    Color currColor=this.getTurn();
    //places the tile at the given row and column
    //if the move is not valid, throw an exception
    //if the move is valid, place the tile and change the turn
    if(row<0 || row>=this.board.size()){
      throw new IllegalArgumentException("invalid row");
    }
    if(column<0 || column>=this.board.get(row).size()){
      throw new IllegalArgumentException("invalid column");
    }
    if(this.board.get(row).get(column).getColor()!=Color.GRAY){
      throw new IllegalArgumentException("invalid move");
    }
    this.board.get(row).set(column,new IDisicImpl(currColor));
    setTurn();

  }

  @Override
  public void passMove() {
    checkIsGameStarted();
    setTurn();

  }

  @Override
  public Color getTurn(){
    checkIsGameStarted();

    return this.turn;
  }

  @Override
  public Integer getLength(){
    checkIsGameStarted();
    return this.length;
  }

  @Override
  public List<List<IDisc>> getBoard(){
   checkIsGameStarted();

    return  this.board;
  }
}
