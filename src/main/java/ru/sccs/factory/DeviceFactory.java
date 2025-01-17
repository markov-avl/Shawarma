package ru.sccs.factory;

import lombok.SneakyThrows;
import ru.sccs.cooking.device.CookingDevice;
import ru.sccs.cooking.device.Pot;
import ru.sccs.cooking.device.Oven;
import ru.sccs.cooking.device.Pan;

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
