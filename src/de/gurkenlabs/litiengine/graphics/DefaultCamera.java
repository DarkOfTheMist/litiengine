/***************************************************************
 * Copyright (c) 2014 - 2015 , gurkenlabs, All rights reserved *
 ***************************************************************/
package de.gurkenlabs.litiengine.graphics;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import de.gurkenlabs.litiengine.Game;

/**
 * The Class DefaultCamera.
 */
public class DefaultCamera extends Camera {

  /*
   * (non-Javadoc)
   *
   * @see de.gurkenlabs.liti.graphics.ICamera#getCenterX()
   */
  @Override
  public double getCenterX() {
    return Game.getScreenManager().getResolution().width / 2.0;
  }

  /*
   * (non-Javadoc)
   *
   * @see de.gurkenlabs.liti.graphics.ICamera#getCenterY()
   */
  @Override
  public double getCenterY() {
    return Game.getScreenManager().getResolution().height / 2.0;
  }

  /*
   * (non-Javadoc)
   *
   * @see de.gurkenlabs.liti.graphics.ICamera#getCameraRegion()
   */
  @Override
  public Rectangle2D getViewPort() {
    return new Rectangle2D.Double(this.getFocus().getX(), this.getFocus().getY(), Game.getScreenManager().getResolution().width, Game.getScreenManager().getResolution().height);
  }

  @Override
  public void updateFocus() {
    this.setFocus(this.applyShakeEffect(new Point2D.Double(this.getCenterX(), this.getCenterY())));
  }
}