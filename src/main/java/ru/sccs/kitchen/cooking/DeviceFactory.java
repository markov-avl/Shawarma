package ru.sccs.kitchen.cooking;

import lombok.SneakyThrows;
import ru.sccs.kitchen.cooking.device.*;

import java.util.List;

public class DeviceFactory {

    List<? extends CookingDevice> allDevices = List.of(
            new Pot("Кастрюля"),
            new Oven("Электрическая печь"),
            new Pan("Керамическая сковорода"),
            new Grill("Гриль")
    );

    @SneakyThrows
    public <T extends CookingDevice> T getFreeDevice(Class<T> deviceType) {
        return allDevices.stream()
                .filter(deviceType::isInstance)
                .map(deviceType::cast)
                .findAny()
                .orElseThrow();
    }

}
