package ru.sccs.cooking.device;

/**
 * Гриль
 */
public class Grill implements CookingDevice {

  @Override
  public void cook() {
    System.out.println("Grilling");
  }
}
