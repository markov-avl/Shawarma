package ru.sccs.cooking.device;


/**
 * Печь
 */
public class Oven implements CookingDevice {

  @Override
  public void cook() {
    System.out.println("Oven is cooking");
  }
}
