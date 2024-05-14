
package deu.ces.pattern_test.ShoppingCart;

import java.util.ArrayList;

public abstract class Subject {
  protected ArrayList<Observer> observers ;
  public void registerObserver(Observer o) {
  }

  public void removeObserver(Observer o) {
  }

  public void notifyObserver() {
  }
}
