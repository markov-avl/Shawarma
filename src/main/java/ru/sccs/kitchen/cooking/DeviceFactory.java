package ru.sccs.kitchen.cooking;

import lombok.SneakyThrows;
import ru.sccs.kitchen.cooking.device.CookingDevice;
import ru.sccs.kitchen.cooking.device.Pot;
import ru.sccs.kitchen.cooking.device.Oven;
import ru.sccs.kitchen.cooking.device.Pan;

import java.util.List;

public class DeviceFactory {

    List<? extends CookingDevice> allDevices = List.of(
            new Pot("Кастрюля"),
            new Oven("Электрическая печь"),
            new Pan("Керамическая сковорода")
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
