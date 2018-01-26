package de.gurkenlabs.litiengine;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class UpdateLoop extends Thread implements ILoop {
  private static final Logger log = Logger.getLogger(UpdateLoop.class.getName());
  private final List<IUpdateable> updatables;

  protected UpdateLoop() {
    this.updatables = new CopyOnWriteArrayList<>();
  }

  @Override
  public void attach(final IUpdateable updatable) {
    if (updatable == null) {
      return;
    }

    if (this.updatables.contains(updatable)) {
      log.log(Level.FINE, "Updatable {0} already registered for update!", new Object[] { updatable });
      return;
    }

    this.updatables.add(updatable);
  }

  @Override
  public void detach(final IUpdateable updatable) {
    this.updatables.remove(updatable);
  }

  protected List<IUpdateable> getUpdatables() {
    return this.updatables;
  }

  protected void update() {
    this.getUpdatables().forEach(updatable -> {
      try {
        if (updatable != null) {
          updatable.update();
        }
      } catch (final Exception e) {
        log.log(Level.SEVERE, e.getMessage(), e);
      }
    });
  }
}
