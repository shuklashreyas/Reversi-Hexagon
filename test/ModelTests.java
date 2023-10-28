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
  public void testInvalidMoves() {
    BasicReversi game = new BasicReversi(6);
    game.startGame();

    game.placeTile(0,0);
    game.placeTile(0,0);

  }

//  @Test
//  public void testValidMove() {
//    BasicReversi game = new BasicReversi(6);
//    game.startGame();
//
//    boolean moveResult = game.makeMove(/* coordinates of a valid move */);
//
//    assertTrue("Valid move was incorrectly rejected", moveResult);
//
//    // Check that the game state has updated correctly
//  }
//
//  @Test
//  public void testGameEnd() {
//    BasicReversi game = new BasicReversi(6);
//    // Set up a game state that represents an end-of-game condition
//
//    assertTrue("Game should be over", game.isGameOver());
//
//    // Check the winner if applicable
//    assertEquals("Unexpected winner", expectedWinner, game.getWinner());
//  }


}
