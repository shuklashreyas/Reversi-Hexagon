import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import cs3500.reversi.model.BasicReversi;
import cs3500.reversi.model.IDisc;
import cs3500.reversi.model.IDiscImpl;
import cs3500.reversi.model.Tuple;
import cs3500.reversi.view.TextualReversiView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModelTests {

  @Test
  public void startGameBoardWorks(){
    BasicReversi game=new BasicReversi(6);
    Assert.assertThrows(IllegalStateException.class,()->game.getBoard());
  }
  @Test
  public void testGetScore(){
    BasicReversi game=new BasicReversi(6);
    game.startGame();
    TextualReversiView view=new TextualReversiView(game);
    System.out.println(view.toString());
    Tuple<Integer,Integer> score=game.getScore();
    assertEquals(Optional.of(3).get(),score.getFirst());
    assertEquals(Optional.of(3).get(),score.getSecond());
  }

  // make tests

  @Test
  public void testInvalidMoveOnOccupiedSpace() {
    BasicReversi game = new BasicReversi(6);
    game.startGame();
    game.placeTile(2, 2);
    Assert.assertThrows(IllegalArgumentException.class, () -> game.placeTile(2, 2));
  }

  @Test
  public void testInvalidMoveOnOutOfBounds() {
    BasicReversi game = new BasicReversi(6);
    game.startGame();
    Assert.assertThrows(IllegalArgumentException.class, () -> game.placeTile(6, 6));
  }

  @Test
  public void testInvalidMoveOnEmptySpace() {
    BasicReversi game = new BasicReversi(6);
    game.startGame();
    Assert.assertThrows(IllegalArgumentException.class, () -> game.placeTile(0, 0));
  }

  @Test
  public void testIsGameOver(){
    BasicReversi game = new BasicReversi(3);
    game.startGame();

    // set up board to be in a game over state
    List<List<IDisc>> board = new ArrayList<>();
    List<IDisc> row1 = new ArrayList<>();
    List<IDisc> row2 = new ArrayList<>();
    List<IDisc> row3 = new ArrayList<>();
    row1.add(new IDiscImpl(BasicReversi.Color.WHITE));
    row1.add(new IDiscImpl(BasicReversi.Color.WHITE));
    row1.add(new IDiscImpl(BasicReversi.Color.WHITE));
    row2.add(new IDiscImpl(BasicReversi.Color.WHITE));
    row2.add(new IDiscImpl(BasicReversi.Color.WHITE));
    row2.add(new IDiscImpl(BasicReversi.Color.WHITE));
    row3.add(new IDiscImpl(BasicReversi.Color.WHITE));
    row3.add(new IDiscImpl(BasicReversi.Color.WHITE));
    row3.add(new IDiscImpl(BasicReversi.Color.WHITE));
    board.add(row1);
    board.add(row2);
    board.add(row3);
    //game.setBoard(board);

    assertEquals(true, game.isGameOver());
  }

  @Test
  public void testIsGameOverWhenNoValidMoves() {
    BasicReversi game = new BasicReversi(6);
    game.startGame();

    // Set up the board in a state where no player can make a move
    List<List<IDisc>> board = new ArrayList<>();
    List<IDisc> row1 = new ArrayList<>();
    List<IDisc> row2 = new ArrayList<>();
    List<IDisc> row3 = new ArrayList<>();
    List<IDisc> row4 = new ArrayList<>();
    List<IDisc> row5 = new ArrayList<>();
    List<IDisc> row6 = new ArrayList<>();
    for(int i = 0; i < 6; i++) {
      row1.add(new IDiscImpl(BasicReversi.Color.WHITE));
      row2.add(new IDiscImpl(BasicReversi.Color.WHITE));
      row3.add(new IDiscImpl(BasicReversi.Color.WHITE));
      row4.add(new IDiscImpl(BasicReversi.Color.WHITE));
      row5.add(new IDiscImpl(BasicReversi.Color.WHITE));
      row6.add(new IDiscImpl(BasicReversi.Color.WHITE));
    }
    board.add(row1);
    board.add(row2);
    board.add(row3);
    board.add(row4);
    board.add(row5);
    board.add(row6);
    //game.setBoard(board);

    //assertTrue(game.isGameOver(), "Game should be over when no player can make a move");
  }

  @Test
  public void testIsValidMove() {
    BasicReversi game = new BasicReversi(6);
    game.startGame();

    // Assuming placing a tile at (2, 3) is a valid move
   // assertTrue(game.isValidMove(2, 3), "Move should be valid");
  }

  @Test
  public void testPlayerPassesTurnScenario() {

      BasicReversi game = new BasicReversi(6);
      game.startGame();

      List<List<IDisc>> board = game.getBoard();

      BasicReversi.Color B = BasicReversi.Color.BLACK;
      BasicReversi.Color W = BasicReversi.Color.WHITE;

      // Define the board state
      BasicReversi.Color[][] boardState = {
              {B, B, B, B, B, B},
              {B, W, W, W, W, B},
              {B, W, B, B, W, B},
              {B, W, B, B, W, B},
              {B, W, W, W, W, B},
              {B, B, B, B, B, B}
      };

      // Set the discs on the board
      for (int row = 0; row < 6; row++) {
        List<IDisc> boardRow = new ArrayList<>();
        for (int col = 0; col < 6; col++) {
          boardRow.add(new IDiscImpl(boardState[row][col]));
        }
        board.set(row, boardRow);
      }

      // Now the board is set up, you can continue with the rest of your test
      game.passMove(); // Player (BLACK) passes their turn

      //assertEquals(BasicReversi.Color.WHITE, game.getTurn(), "Next player (WHITE) should now be active");
    }

  @Test
  public void testBlackWins() {
    BasicReversi game = new BasicReversi(6);  // Assuming 6 is a valid board size
    game.startGame();

    // Manually set up the board for a scenario where Black wins
    List<List<IDisc>> board = game.getBoard();

    // This code assumes that the board is a List of Lists representing a hexagonal grid
    for (int row = 0; row < board.size(); row++) {
      List<IDisc> currentRow = board.get(row);
      for (int col = 0; col < currentRow.size(); col++) {
        if (row % 2 == 0) {
          currentRow.set(col, new IDiscImpl(BasicReversi.Color.BLACK));
        } else {
          currentRow.set(col, new IDiscImpl(BasicReversi.Color.WHITE));
        }
      }
    }
    // Check if Black is the winner
    // TODO Implement getWinner() method
    //assertEquals(BasicReversi.Color.BLACK, game.getWinner(), "Black should be the winner");
  }


}

