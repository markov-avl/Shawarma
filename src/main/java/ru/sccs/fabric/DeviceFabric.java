package ru.sccs.fabric;

import ru.sccs.cooking.device.CookingDevice;
import ru.sccs.cooking.device.Oven;

public class DeviceFabric {

  public CookingDevice getFreeDevice(Class<? extends CookingDevice> device) {
    return new Oven("Grill");
  }
}
