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

  private List<Tuple<Integer, Integer>> directions=new ArrayList<>();

  private List<List<IDisc>> board=new ArrayList<>();

  private void checkIsGameStarted(){
    if(!isGameStarted){
      throw new IllegalStateException("game is not started");
    }
  }

  private void initializeDirections(){
    this.directions.add(new Tuple<>(0,1));
    this.directions.add(new Tuple<>(-1,0));
    this.directions.add(new Tuple<>(1,-1));
    this.directions.add(new Tuple<>(1,0));
    this.directions.add(new Tuple<>(-1,-1));
    this.directions.add(new Tuple<>(0,-1));
  }

  private List<IDisc> fillBoard(Integer rowLength){
    List<IDisc> row=new ArrayList<>();
    for(int i=0; i<rowLength; i++){
      row.add(new IDiscImpl(Color.GRAY));
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

//    //goes in the top right direction
//    directions.add(new Tuple<>(-2,0));
//    directions.add(new Tuple<>(-3,0));
//    directions.add(new Tuple<>(-4,0));
//    directions.add(new Tuple<>(-5,0));
//
//    //goes in the right direction
//    directions.add(new Tuple<>(0,2));
//
//    //goes in the left direction
//    directions.add(new Tuple<>(0,-2));
//
//    //goes in the top left idrection
//    directions.add(new Tuple<>(-2,-2));
//    directions.add(new Tuple<>(-3,-3));
//
//    //goes in the bottom right direction
//    directions.add(new Tuple<>(2,0));
//
//    //goes in bottom left direction
//    directions.add(new Tuple<>(2,-2));

    //board.get(center.getFirst()).set(center.getSecond(),new IDiscImpl(Color.BLACK));

    while (numPieces > 0) {
      if (!directions.isEmpty()) {
        Tuple<Integer, Integer> direction = this.directions.remove(0);
        int newRow = center.getFirst() + direction.getFirst();
        int newCol = center.getSecond() + direction.getSecond();
        board.get(newRow).set(newCol, new IDiscImpl(currColor));
        numPieces--;
        currColor = (currColor == Color.BLACK) ? Color.WHITE : Color.BLACK;
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
    initializeDirections();
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

  private void dfs(int row, int column){
    List<Tuple<Integer,Integer>> directions=new ArrayList<>();
    directions.add(new Tuple<>(0,1));
    directions.add(new Tuple<>(-1,0));
    directions.add(new Tuple<>(1,-1));
    directions.add(new Tuple<>(1,0));
    directions.add(new Tuple<>(-1,-1));
    directions.add(new Tuple<>(0,-1));





  }
  private void isValidMove(int row, int column){
    List<Tuple<Integer,Integer>> directions=new ArrayList<>();

  }
  @Override
  public void placeTile(int row, int column) {
    checkIsGameStarted();
    Color currColor=this.getTurn();





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