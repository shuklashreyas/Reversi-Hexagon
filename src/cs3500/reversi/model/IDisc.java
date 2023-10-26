package cs3500.reversi.model;

import java.awt.image.ColorConvertOp;

public interface IDisc {

  /**
   * Method to get the string of the IDisc
   * @return String representation of the IDisc
   */
  String toString();

  /**
   * Sets the visibility of the disc.
   */
  void setColor(BasicReversi.Color newColor);

  /**
   * Gets the Color of the dics
   */
  BasicReversi.Color getColor();


}
