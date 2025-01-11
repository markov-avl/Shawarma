package ru.sccs.cooking.device;

/**
 * Кастрюля
 */
public class Pan implements CookingDevice {

    @Override
    public void cook() {
        System.out.println("Pan is cooking");
    }

}
