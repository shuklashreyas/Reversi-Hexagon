import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import cs3500.reversi.model.BasicReversi;
import cs3500.reversi.model.Tuple;
import cs3500.reversi.view.TextualReversiView;

public class PlayerTests {

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
    Assert.assertEquals(Optional.of(3).get(),score.getFirst());
    Assert.assertEquals(Optional.of(3).get(),score.getSecond());
  }

  @Test
  public void getBoard(){
    BasicReversi game=new BasicReversi(6);
    game.startGame();
    System.out.println(game.getBoard());

  }



}
