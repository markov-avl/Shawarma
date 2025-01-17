package ru.sccs.recipe;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.sccs.command.Command;
import ru.sccs.cooking.device.CookingDevice;

import java.util.function.Function;


@Data
@RequiredArgsConstructor
public class RecipeStep {

    private final Class<? extends CookingDevice> deviceType;

    private final Function<CookingDevice, Command> commandMaker;

}
