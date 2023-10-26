package cs3500.reversi.view;

import java.util.List;

import cs3500.reversi.model.BasicReversi;
import cs3500.reversi.model.IDisc;
import cs3500.reversi.model.Reversi;

public class TextualReversiView implements ReversiView{
  private final Reversi model;
  // ... any other fields you need

  public TextualReversiView(Reversi model) {
    this.model = model;

  }

  private String addSpaces(int numSpaces, List<IDisc> row){
    StringBuilder sb=new StringBuilder();
    for(int i=0; i<numSpaces; i++){
      sb.append(" ");
    }
    for(IDisc disc:row){
      if(disc.getColor()== BasicReversi.Color.GRAY){
        sb.append("_ ");
      }
      if(disc.getColor()== BasicReversi.Color.WHITE){
        sb.append("0 ");
      }
      if(disc.getColor()==BasicReversi.Color.BLACK){
        sb.append("X ");
      }
    }
    for(int i=0; i<numSpaces; i++){
      sb.append(" ");
    }
    return sb.toString();

  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    int numSpaces=model.getLength()-1;
    int index=0;

    while(index<model.getBoard().size()/2){
      List<IDisc> row=model.getBoard().get(index);
      String newRow=addSpaces(numSpaces,row);
      sb.append(newRow+"\n");
      numSpaces--;
      index++;
    }

    int numBottomSpaces=0;

    while(index<model.getBoard().size()){
      List<IDisc> row=model.getBoard().get(index);
      String newRow=addSpaces(numBottomSpaces,row);
      sb.append(newRow+"\n");
      numBottomSpaces++;
      index++;
    }

    return sb.toString();
  }
}
