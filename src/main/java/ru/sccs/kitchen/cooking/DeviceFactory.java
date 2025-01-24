package ru.sccs.kitchen.cooking;

import ru.sccs.kitchen.cooking.device.*;

import java.util.List;

public class DeviceFactory {

    private static final List<? extends CookingDevice> DEVICES = List.of(
            new Pot("Кастрюля"),
            new Oven("Электрическая печь"),
            new Pan("Керамическая сковорода"),
            new Grill("Гриль")
    );

    public static <T extends CookingDevice> T getFreeDevice(Class<T> deviceType) {
        return DEVICES.stream()
                .filter(deviceType::isInstance)
                .map(deviceType::cast)
                .findAny()
                .orElseThrow();
    }

}
