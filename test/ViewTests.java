import org.junit.Test;

import cs3500.reversi.model.BasicReversi;
import cs3500.reversi.view.TextualReversiView;

public class ViewTests {


  @Test
  public void testView(){
    BasicReversi model=new BasicReversi(6);
    model.startGame();
    TextualReversiView view=new TextualReversiView(model);
    System.out.println(view.toString());
  }
}
