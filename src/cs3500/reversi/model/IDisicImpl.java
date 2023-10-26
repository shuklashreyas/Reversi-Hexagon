package cs3500.reversi.model;

public class IDisicImpl implements IDisc {
  private BasicReversi.Color color;

  public IDisicImpl( BasicReversi.Color color){
    this.color=color;
  }

  @Override
  public void setColor(BasicReversi.Color newColor) {
    this.color=newColor;
  }

  @Override
  public BasicReversi.Color getColor(){
    return this.color;
  }



  @Override
  public String toString(){
    return this.color.toString();
  }

}
